#!/bin/bash

echo "Running kubectl commands..."

kubectl apply -f zipkin/deployment.yaml
kubectl apply -f zipkin/service.yaml

kubectl apply -f rabbitmq/pv.yaml
kubectl apply -f rabbitmq/pvc.yaml
kubectl apply -f rabbitmq/deployment.yaml
kubectl apply -f rabbitmq/service.yaml

kubectl apply -f mysql/student/pv.yaml
kubectl apply -f mysql/student/pvc.yaml
kubectl apply -f mysql/student/deployment.yaml
kubectl apply -f mysql/student/service.yaml

kubectl apply -f mysql/employee/pv.yaml
kubectl apply -f mysql/employee/pvc.yaml
kubectl apply -f mysql/employee/deployment.yaml
kubectl apply -f mysql/employee/service.yaml

kubectl apply -f ServiceRegistry/deployment.yaml
kubectl apply -f ServiceRegistry/service.yaml

kubectl apply -f student/deployment.yaml
kubectl apply -f student/service.yaml

kubectl apply -f employee/deployment.yaml
kubectl apply -f employee/service.yaml

kubectl apply -f messaging/deployment.yaml
kubectl apply -f messaging/service.yaml

kubectl apply -f feignclient/deployment.yaml
kubectl apply -f feignclient/service.yaml

kubectl apply -f apigateway/deployment.yaml
kubectl apply -f apigateway/service.yaml