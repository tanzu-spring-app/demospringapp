package com.rabbitmq.messaging.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.amqp.core.Queue;

@Service
public class RabbitMQService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue myQueue;

    public void sendMessage(String message) {
        // Send a message to the "myQueue" queue
        rabbitTemplate.convertAndSend(myQueue.getName(), message);
        System.out.println("Message sent: " + message);
    }

    public String receiveMessage() {
        // Receive a message from the "myQueue" queue
        Object message = rabbitTemplate.receiveAndConvert(myQueue.getName());
        if (message != null) {
            String received = message.toString();
            System.out.println("Message received: " + received);
            return received;
        } else {
            System.out.println("No message received");
            return "No Message";
        }
    }
}
