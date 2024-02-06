package com.rabbitmq.messaging.rabbitmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitMQController {

    @Value("${KUBERNETES_SERVICE_NAME:unknown}")
    private String kubernetesServiceName;

    @Autowired
    private RabbitMQService rabbitMQService;

    @PostMapping("/send")
    public void sendMessage(@RequestBody String message) {
        rabbitMQService.sendMessage(message);
    }

    @GetMapping("/receive")
    public String receiveMessage() {
        return rabbitMQService.receiveMessage();
    }

    @GetMapping("/k8s-servicename")
    public String getK8sServiceName() {
        return "Kubernetes Service Name: " + kubernetesServiceName;
    }
}
