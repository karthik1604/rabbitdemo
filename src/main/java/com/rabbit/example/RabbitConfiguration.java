package com.rabbit.example;


import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
@RefreshScope
public class RabbitConfiguration {

    @Value("{queueName}")
    private String queue;

    @Value("{dlqName}")
    private String dlq;

    @Bean
    @RefreshScope
    public Queue hellodlQ()
    {
        return new Queue(dlq);
    }

    @Bean
    public RabbitTemplate rabbittemplate(ConnectionFactory connectionFactory)
    {
        return new RabbitTemplate(connectionFactory);
    }

    @Bean
    @RefreshScope
    Queue incomingQueue() {
        return QueueBuilder.durable(queue)
                .withArgument("x-dead-letter-exchange", "")
                .withArgument("x-dead-letter-routing-key", "helloDLQ")
                .build();
    }

}
