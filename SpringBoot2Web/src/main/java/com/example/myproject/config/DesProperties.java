package com.example.myproject.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 配置文件的读取。
 * 这里是通过@Value注解获取单个配置文件里面的数据，"${}"是spring提供的属性占位符写法。
 * 而常说的Spring的SpEl表达式是"#{}"写法。SpEl表达式功能上比属性占位符功能要多些，可以计算，输出等。
 */
@Component
public class DesProperties {
    @Value("${com.exo.title}")
    private String title;
    @Value("${com.exo.description}")
    private String description;

    // 使用@Value注解需要提供Getter和Setter方法


    public DesProperties() {
        System.out.println("title:"+title+", description:"+description);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
