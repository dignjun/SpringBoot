package com.example8.process;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 一对多发送。结果接受者【均匀】接收到消息
 */
@Component
public class HelloSender12 {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        for (int i = 0; i < 100; i++) {
            String context = "hello:" + i + new Date();
            System.out.println("Sender:" + context);
            this.rabbitTemplate.convertAndSend("hello12", context);
        }
    }
}
