# demospringapp
Demo Project For Spring Application Discovery in Tanzu

1. Initially create Satefull deployments to create space for data store
	Under mysql, there are two folders: employee and student
	For each one run
		a. kubectl apply -f pv.yaml 
		a. kubectl apply -f pvc.yaml 
		a. kubectl apply -f deployment.yaml 
	In order given above, if you are using minikube keep files as it is. Otherwise change hostPath location in pv.yaml and deployment.yaml

	Perform above three steps for rabbitmq as well

2. Expose above databses and rabbitmq as services
	kubectl expose deployment student-db --type=ClusterIP --port=3306 --target-port=3306 --name=student-db
	kubectl expose deployment employee-db --type=ClusterIP --port=3306 --target-port=3306 --name=employee-db
	kubectl expose deployment rabbitmq-deployment --type=ClusterIP --port=5672 --target-port=5672

3. RUN kubectl get services, and note down all IP address (ClusterIps)
4. Perform mvn clean install in each spring app before proceeding

5. If do not have images on public registry
	Install Kind (brew install kind)
	kind create cluster

6. Perform below commands if using kind else only run deployment.yaml by adding imagePullSecrets
	(Make sure to update deployment.yaml with proper IP address that are required in env section)

	docker build -t demospringapp/serviceregistry:1 .
	kind load docker-image demospringapp/serviceregistry:1
	kubectl apply -f deployment.yaml
	kubectl expose deployment service-registry --type=LoadBalancer --port=8761 --target-port=8761

	docker build -t demospringapp/student:1 .
	kind load docker-image demospringapp/student:1
	## change - ip in deployment.yaml
	kubectl apply -f deployment.yaml
	kubectl expose deployment student-app --type=ClusterIP --port=8081 --target-port=8081

	docker build -t demospringapp/employee:1 .
	kind load docker-image demospringapp/employee:1
	## change - ip in deployment.yaml
	kubectl apply -f deployment.yaml
	kubectl expose deployment employee-app --type=ClusterIP --port=8082 --target-port=8082

	docker build -t demospringapp/messaging:1 .
	kind load docker-image demospringapp/messaging:1
	## change - ip in deployment.yaml
	kubectl apply -f deployment.yaml
	kubectl expose deployment messaging-app --type=ClusterIP --port=8083 --target-port=8083

	docker build -t demospringapp/demospringapp:1 .
	kind load docker-image demospringapp/demospringapp:1
	## change - ip in deployment.yaml
	kubectl apply -f deployment.yaml
	kubectl expose deployment demospringapp --type=LoadBalancer --port=8080 --target-port=8080