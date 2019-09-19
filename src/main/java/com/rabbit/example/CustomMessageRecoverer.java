package com.rabbit.example;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.exception.ListenerExecutionFailedException;
import org.springframework.amqp.rabbit.retry.MessageRecoverer;
import org.springframework.amqp.rabbit.retry.RejectAndDontRequeueRecoverer;
import org.springframework.stereotype.Component;

@Component
public class CustomMessageRecoverer implements MessageRecoverer {

    @Override
    public void recover(Message message, Throwable cause) {
        System.out.println("Cant retry anymore");
        throw new ListenerExecutionFailedException("Retry Policy Exhausted",
                new AmqpRejectAndDontRequeueException(cause), message);
    }
}
