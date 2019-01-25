package com.example8.process;

import com.example8.entity.Car;
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
        // 发送String
        this.rabbitTemplate.convertAndSend("hello", context);
        this.rabbitTemplate.convertAndSend("hello", context);
        // 发送Object
        this.rabbitTemplate.convertAndSend("hello", new Car("大众", "VW", "12.12"));
    }

    public void send1() {
        String context = "hi, i am message 1";
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("exchange", "topic.message", context);
    }

    public void send2() {
        String context = "hi, i am messages 2";
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("exchange", "topic.messages", context);
    }

    public void send3() {
        String context = "hi, fanout msg ";
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("fanoutExchange","", context);
    }
}
