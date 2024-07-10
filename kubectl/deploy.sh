#!/bin/bash

echo "Building and deploying Trips application on Kubernetes..."

# Navigate to the postgres container directory
pushd postgres || exit

# Apply Postgres configurations
kubectl apply -f configMap.yaml
kubectl apply -f postgres-pv.yaml
kubectl apply -f postgres-pvc.yaml
kubectl apply -f postgres-deployment.yaml
kubectl apply -f postgres-service.yaml

# Return to the original directory
popd || exit

# Navigate to the pgadmin container directory
pushd pgadmin || exit

# Apply Pg Admin configurations
kubectl apply -f pgadmin-deployment.yaml
kubectl apply -f pgadmin-service.yaml

# Return to the original directory
popd || exit

# Navigate to the Keycloak container directory
pushd keycloak || exit

chmod +x keycloak-entrypoint.sh

# Apply Keycloak configurations
kubectl apply -f configMap.yaml
kubectl apply -f keycloak-deployment.yaml
kubectl apply -f keycloak-deployment.yaml
kubectl apply -f keycloak-service.yaml

# Return to the original directory
popd || exit

# Get Kubernetes pods and services
echo "List all pods container."
kubectl get pods

echo "Deployment completed."
kubectl get svc

echo "Deployment completed."

echo "Launch kubernetes Dashboard."
minikube dashboard
