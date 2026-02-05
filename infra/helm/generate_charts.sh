#!/bin/bash

# Service configurations
declare -A services
services=( 
    ["user-service"]="9090:user-db" 
    ["auth-service"]="9091:auth-db" 
    ["catalog-service"]="9092:catalog-db" 
    ["subscription-service"]="9093:subscription-db" 
    ["billing-service"]="9094:billing-db" 
)

TEMPLATE_DIR="infra/helm"

for service in "${!services[@]}"; do
    IFS=':' read -r port dbname <<< "${services[$service]}"
    
    echo "Generating chart for $service (Port: $port, DB: $dbname)..."
    
    mkdir -p "infra/helm/$service/templates"
    
    # Copy and Replace Chart.yaml
    sed "s/SERVICE_NAME/$service/g" "$TEMPLATE_DIR/chart_template.yaml" > "infra/helm/$service/Chart.yaml"
    
    # Copy and Replace values.yaml
    sed -e "s/SERVICE_NAME/$service/g" \
        -e "s/SERVICE_PORT/$port/g" \
        -e "s/SERVICE_DB/$dbname/g" \
        "$TEMPLATE_DIR/values_template.yaml" > "infra/helm/$service/values.yaml"
        
    # Copy Templates
    cp "$TEMPLATE_DIR/deployment_template.yaml" "infra/helm/$service/templates/deployment.yaml"
    cp "$TEMPLATE_DIR/service_template.yaml" "infra/helm/$service/templates/service.yaml"
    cp "$TEMPLATE_DIR/helpers_template.tpl" "infra/helm/$service/templates/_helpers.tpl"

done

# Cleanup templates
rm "$TEMPLATE_DIR/chart_template.yaml"
rm "$TEMPLATE_DIR/deployment_template.yaml"
rm "$TEMPLATE_DIR/service_template.yaml"
rm "$TEMPLATE_DIR/values_template.yaml"
rm "$TEMPLATE_DIR/helpers_template.tpl"

echo "Helm charts generated successfully."
