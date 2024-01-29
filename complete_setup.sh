#!/bin/bash

echo "Deploying docker images..."

cd ServiceRegistry
mvn clean install
docker build -t demospringapp/serviceregistry:1 .
kind load docker-image demospringapp/serviceregistry:1
cd ..


cd student
mvn clean install
docker build -t demospringapp/student:1 .
kind load docker-image demospringapp/student:1
cd ..


cd employee
mvn clean install
docker build -t demospringapp/employee:1 .
kind load docker-image demospringapp/employee:1
cd ..


cd messaging
mvn clean install
docker build -t demospringapp/messaging:1 .
kind load docker-image demospringapp/messaging:1
cd ..


cd feignclient
mvn clean install
docker build -t demospringapp/feignwebclient:1 .
kind load docker-image demospringapp/feignwebclient:1
cd ..


cd apigateway
mvn clean install
docker build -t demospringapp/demospringapp:1 .
kind load docker-image demospringapp/demospringapp:1
cd ..



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