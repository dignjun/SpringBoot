package com.example8.rabbitmqconfig;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    @Bean
    public Queue queue() {
        return new Queue("hello");
    }
    @Bean
    public Queue queue12() {
        return new Queue("hello12");
    }
}
