package com.rabbit.example;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@RabbitListener(queues = "hello")
@Component
public class HelloListener {

    @RabbitHandler
    public void receive(String message)
    {
        if(true) throw new RuntimeException("");
        System.out.println(message);
    }
}
