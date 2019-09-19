package com.rabbit.example;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class HelloPublisher {

    private RabbitTemplate rabbitTemplate;

    public HelloPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void send(String message)
    {
        rabbitTemplate.convertAndSend("hello",message);
    }
}
