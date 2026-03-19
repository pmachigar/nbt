# -------------------------------------------------------------------------------------------------
# Network: VPC, Subnets, Internet Gateway
# -------------------------------------------------------------------------------------------------
module "vpc" {
  source  = "terraform-aws-modules/vpc/aws"
  version = "5.5.0"

  name = "antigravity-vpc-${var.environment}"
  cidr = var.vpc_cidr

  azs             = var.availability_zones
  private_subnets = var.private_subnet_cidrs
  public_subnets  = var.public_subnet_cidrs

  enable_nat_gateway = true
  single_nat_gateway = true

  tags = {
    Name = "antigravity-vpc"
  }
}

# Security Group for RDS PostgreSQL
resource "aws_security_group" "rds_sg" {
  name        = "antigravity-rds-sg-${var.environment}"
  description = "Security group for Antigravity RDS PostgreSQL instance"
  vpc_id      = module.vpc.vpc_id

  ingress {
    description = "Allow PostgreSQL traffic from intra-vpc"
    from_port   = 5432
    to_port     = 5432
    protocol    = "tcp"
    cidr_blocks = [module.vpc.vpc_cidr_block]
  }

  egress {
    from_port   = 0
    to_port     = 0
    protocol    = "-1"
    cidr_blocks = ["0.0.0.0/0"]
  }
}

# -------------------------------------------------------------------------------------------------
# Storage: RDS PostgreSQL for structured tracking/config (Requires PostGIS extension to be run via SQL later)
# -------------------------------------------------------------------------------------------------
resource "aws_db_subnet_group" "rds_subnet_group" {
  name       = "antigravity-rds-subnet-group-${var.environment}"
  subnet_ids = module.vpc.private_subnets
  description = "Subnet group for RDS DB"
}

resource "aws_db_instance" "postgres" {
  identifier             = "antigravity-db-${var.environment}"
  engine                 = "postgres"
  engine_version         = "15.4"
  instance_class         = var.db_instance_class
  allocated_storage      = 20
  max_allocated_storage  = 100
  storage_encrypted      = true
  kms_key_id             = aws_kms_key.antigravity_key.arn
  
  db_name                = "antigravity"
  username               = var.db_username
  password               = var.db_password # In production, pull from AWS Secrets Manager
  
  db_subnet_group_name   = aws_db_subnet_group.rds_subnet_group.name
  vpc_security_group_ids = [aws_security_group.rds_sg.id]
  
  skip_final_snapshot    = true
  multi_az               = false # Set to true in prod
}

# -------------------------------------------------------------------------------------------------
# Storage: Amazon Timestream for sensor time-series data
# -------------------------------------------------------------------------------------------------
resource "aws_timestreamwrite_database" "telemetry_db" {
  database_name = "antigravity-telemetry-${var.environment}"
  kms_key_id    = aws_kms_key.antigravity_key.arn
}

resource "aws_timestreamwrite_table" "telemetry_table" {
  database_name = aws_timestreamwrite_database.telemetry_db.database_name
  table_name    = "sensors"

  retention_properties {
    magnetic_store_retention_period_in_days = 365
    memory_store_retention_period_in_hours  = 24
  }
}

# -------------------------------------------------------------------------------------------------
# Ingestion: Kinesis Data Stream
# -------------------------------------------------------------------------------------------------
resource "aws_kinesis_stream" "telemetry_stream" {
  name             = "antigravity-telemetry-stream-${var.environment}"
  shard_count      = 1
  retention_period = 24
  
  stream_mode_details {
    stream_mode = "PROVISIONED"
  }
  
  encryption_type = "KMS"
  kms_key_id      = aws_kms_key.antigravity_key.arn
}
