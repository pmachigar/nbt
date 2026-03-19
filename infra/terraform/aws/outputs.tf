output "vpc_id" {
  description = "The ID of the VPC"
  value       = module.vpc.vpc_id
}

output "rds_endpoint" {
  description = "The connection endpoint for the RDS PostgreSQL instance"
  value       = aws_db_instance.postgres.endpoint
}

output "kinesis_stream_arn" {
  description = "The ARN of the Kinesis Data Stream"
  value       = aws_kinesis_stream.telemetry_stream.arn
}

output "timestream_database_name" {
  value = aws_timestreamwrite_database.telemetry_db.database_name
}

output "iot_endpoint_address" {
  description = "AWS IoT Core data ATS endpoint"
  value       = data.aws_iot_endpoint.iot_endpoint.endpoint_address
}

# Fetch endpoint for completeness
data "aws_iot_endpoint" "iot_endpoint" {
  endpoint_type = "iot:Data-ATS"
}
