package com.example8.process;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 一对一发送
 */
@Component
public class HelloSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        System.out.println("TemplateType:" + rabbitTemplate);
        String context = "hello" + new Date();
        System.out.println("Sender:" + context);
        this.rabbitTemplate.convertAndSend("hello", context);
    }
}
