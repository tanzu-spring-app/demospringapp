# demospringapp
Demo Project For Spring Application Discovery in Tanzu  

Follow complete_setup.sh to deploy the application in the local Kubernetes cluster using Kind control plane.
Install in your local docker, minikube, and kind.

kind create cluster

Pull Mysql, RabbitMq and Zipkin images
1. docker pull mysql:8
2. docker pull rabbitmq
3. docker pull openzipkin/zipkin

Follow complete_setup.sh to deploy application

