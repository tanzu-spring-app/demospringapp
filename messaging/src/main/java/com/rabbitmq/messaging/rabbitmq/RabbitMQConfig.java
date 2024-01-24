package com.rabbitmq.messaging.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    // Define a queue with name "myQueue"
    @Bean
    public Queue myQueue() {
        return new Queue("myQueue");
    }
}

