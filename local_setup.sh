#!/bin/bash

echo "Running kubectl commands..."

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
