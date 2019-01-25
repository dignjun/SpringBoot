package com.example8.process;

import com.example8.entity.Car;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 一对一，接受者
 */
@Component
@RabbitListener(queues = "hello")
public class HelloReceiver {
    @RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver:" + hello);
    }
    // 发了两个消息，这里只使用process(String hello)处理。只能处理第一条消息，第二条处理不了。而且形参类型需要匹配。
    @RabbitHandler
    public void processObj(Car car){
        System.out.println("Receiver Car:" + car);
    }
}
