terraform {
  required_providers {
    alicloud = {
      source  = "aliyun/alicloud"
      version = "~> 1.0" // Check for latest stable
    }
  }
}

provider "alicloud" {
  region = var.region
}

variable "region" {
  default = "cn-hangzhou"
}

# VPC
resource "alicloud_vpc" "vpc" {
  vpc_name   = "nbt-vpc"
  cidr_block = "10.0.0.0/16"
}

resource "alicloud_vswitch" "vswitch" {
  vpc_id     = alicloud_vpc.vpc.id
  cidr_block = "10.0.1.0/24"
  zone_id    = "${var.region}-b"
}

# Managed Kubernetes
resource "alicloud_cs_managed_kubernetes" "k8s" {
  name                      = "nbt-cluster"
  cluster_spec              = "ack.pro.small"
  worker_vswitch_ids        = [alicloud_vswitch.vswitch.id]
  new_nat_gateway           = true
  pod_cidr                  = "172.20.0.0/16"
  service_cidr              = "172.21.0.0/20"
  slb_internet_enabled      = true
}

# Node Pool with Auto Scaling
resource "alicloud_cs_kubernetes_node_pool" "default" {
  name                 = "default-pool"
  cluster_id           = alicloud_cs_managed_kubernetes.k8s.id
  vswitch_ids          = [alicloud_vswitch.vswitch.id]
  
  scaling_config {
    min_size = 1
    max_size = 10
  }

  instance_types = ["ecs.g6.large"]
}
