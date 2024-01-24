package com.rabbitmq.messaging.rabbitmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitMQController {

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
}
