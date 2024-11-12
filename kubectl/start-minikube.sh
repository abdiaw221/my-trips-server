#!/bin/bash

# Function to check if a command exists
command_exists() {
  command -v "$1" >/dev/null 2>&1
}

# Check if Minikube is installed
if ! command_exists minikube; then
  echo "Minikube is not installed. Please install Minikube first."
  exit 1
fi

# Set the desired Kubernetes version (optional)
K8S_VERSION=v1.30.0

# Start Minikube with the specified Kubernetes version
echo "Starting Minikube with Kubernetes version $K8S_VERSION..."
minikube start --kubernetes-version=$K8S_VERSION

# Check if Minikube started successfully
if [ $? -ne 0 ]; then
  echo "Failed to start Minikube."
  exit 1
fi

# Set up kubectl to use the Minikube context
echo "Setting up kubectl to use the Minikube context..."
kubectl config use-context minikube

# Confirm Minikube and kubectl setup
echo "Minikube is running with Kubernetes version:"
kubectl version --short

echo "Minikube status:"
minikube status

echo "Kubectl is now using the Minikube context:"
kubectl config current-context

echo "Minikube setup complete. You can now use kubectl to interact with your local Kubernetes cluster."
