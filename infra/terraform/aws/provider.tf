terraform {
  required_version = ">= 1.5.0"
  
  backend "s3" {
    bucket         = "antigravity-terraform-state-bucket"
    key            = "aws/antigravity-base/terraform.tfstate"
    region         = "us-east-1"
    encrypt        = true
    dynamodb_table = "antigravity-terraform-locks"
  }

  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~> 5.0"
    }
  }
}

provider "aws" {
  region = var.aws_region
  
  default_tags {
    tags = {
      Project     = "Antigravity"
      Environment = var.environment
      ManagedBy   = "Terraform"
    }
  }
}

# -------------------------------------------------------------------------------------------------
# KMS - Customer Managed Key for encryption
# -------------------------------------------------------------------------------------------------
resource "aws_kms_key" "antigravity_key" {
  description             = "KMS Key for Antigravity biometric and telemetry data"
  deletion_window_in_days = 30
  enable_key_rotation     = true
}

resource "aws_kms_alias" "antigravity_key_alias" {
  name          = "alias/antigravity-data-key"
  target_key_id = aws_kms_key.antigravity_key.key_id
}
