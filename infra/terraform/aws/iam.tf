data "aws_caller_identity" "current" {}

# -------------------------------------------------------------------------------------------------
# IAM: IoT to Kinesis Role
# -------------------------------------------------------------------------------------------------
resource "aws_iam_role" "iot_kinesis_role" {
  name = "antigravity-iot-kinesis-role"
  assume_role_policy = jsonencode({
    Version = "2012-10-17"
    Statement = [{
      Action = "sts:AssumeRole"
      Effect = "Allow"
      Principal = { Service = "iot.amazonaws.com" }
    }]
  })
}

resource "aws_iam_role_policy" "iot_kinesis_policy" {
  name = "antigravity-iot-kinesis-policy"
  role = aws_iam_role.iot_kinesis_role.id
  policy = jsonencode({
    Version = "2012-10-17"
    Statement = [
      {
        Action = ["kinesis:PutRecord"]
        Effect = "Allow"
        Resource = aws_kinesis_stream.telemetry_stream.arn
      }
    ]
  })
}

# -------------------------------------------------------------------------------------------------
# Compute: AWS Lambda Processor
# -------------------------------------------------------------------------------------------------
resource "aws_iam_role" "lambda_exec_role" {
  name = "antigravity-telemetry-lambda-role"
  assume_role_policy = jsonencode({
    Version = "2012-10-17"
    Statement = [{
      Action = "sts:AssumeRole"
      Effect = "Allow"
      Principal = { Service = "lambda.amazonaws.com" }
    }]
  })
}

resource "aws_iam_role_policy" "lambda_exec_policy" {
  name = "antigravity-telemetry-lambda-policy"
  role = aws_iam_role.lambda_exec_role.id
  policy = jsonencode({
    Version = "2012-10-17"
    Statement = [
      {
        Action = [
          "kinesis:GetRecords",
          "kinesis:GetShardIterator",
          "kinesis:DescribeStream",
          "kinesis:ListShards"
        ]
        Effect = "Allow"
        Resource = aws_kinesis_stream.telemetry_stream.arn
      },
      {
        Action = [
          "timestream:WriteRecords",
          "timestream:DescribeEndpoints"
        ]
        Effect = "Allow"
        Resource = "*" # Timestream requires explicit endpoints or * for DescribeEndpoints
      },
      {
        Action = ["logs:CreateLogGroup", "logs:CreateLogStream", "logs:PutLogEvents"]
        Effect = "Allow"
        Resource = "arn:aws:logs:*:*:*"
      }
    ]
  })
}

# Create a zip with dummy handler for tf to succeed, user will upload real code via CI/CD
data "archive_file" "lambda_zip" {
  type        = "zip"
  output_path = "$${path.module}/dummy_lambda.zip"
  source {
    content  = "exports.handler = async (event) => { return 'Success'; };"
    filename = "index.js"
  }
}

resource "aws_lambda_function" "telemetry_processor" {
  function_name    = "antigravity-telemetry-processor-${var.environment}"
  role             = aws_iam_role.lambda_exec_role.arn
  handler          = "index.handler"
  runtime          = "nodejs18.x"
  filename         = data.archive_file.lambda_zip.output_path
  source_code_hash = data.archive_file.lambda_zip.output_base64sha256

  environment {
    variables = {
      TIMESTREAM_DB    = aws_timestreamwrite_database.telemetry_db.database_name
      TIMESTREAM_TABLE = aws_timestreamwrite_table.telemetry_table.table_name
    }
  }
}

# Connect Lambda to Kinesis Stream
resource "aws_lambda_event_source_mapping" "kinesis_trigger" {
  event_source_arn  = aws_kinesis_stream.telemetry_stream.arn
  function_name     = aws_lambda_function.telemetry_processor.arn
  starting_position = "LATEST"
}
