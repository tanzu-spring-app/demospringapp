#!/bin/bash

echo "Deploy apps..."

cd ServiceRegistry
mvn clean install
cd ..

cd student
mvn clean install
cd ..

cd employee
mvn clean install
cd ..

cd messaging
mvn clean install
cd ..

cd feignclient
mvn clean install
cd ..

cd apigateway
mvn clean install
cd ..

java -jar ServiceRegistry/target/ServiceRegistry-0.0.1-SNAPSHOT.jar &
java -jar student/target/student-0.0.1-SNAPSHOT.jar &
java -jar employee/target/employee-0.0.1-SNAPSHOT.jar &
java -jar messaging/target/messaging-0.0.1-SNAPSHOT.jar &
java -jar feignclient/target/feignclient-0.0.1-SNAPSHOT.jar &
java -jar apigateway/target/apigateway-0.0.1-SNAPSHOT.jar &