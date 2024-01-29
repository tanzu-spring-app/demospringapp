#!/bin/bash

echo "Running kubectl commands..."

kubectl apply -f mysql/student/pv.yaml
kubectl apply -f mysql/student/pvc.yaml
kubectl apply -f mysql/student/deployment.yaml
kubectl apply -f mysql/student/service.yaml
# Add more kubectl commands as needed

