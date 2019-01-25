package com.example;

import com.example7.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class DataSourcesTest {

    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void dataSourceTest(){
//        new ApplicationContextAware(){
//
//            @Override
//            public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//                System.out.println(applicationContext.getBean("test1SqlSessionFactory"));
//                System.out.println(applicationContext.getBean("test2SqlSessionFactory"));
//            }
//        };
        // 输出表明，这是两个sqlSessionFactory。
        System.out.println("test1SqlSessionFactory:"+applicationContext.getBean("test1SqlSessionFactory"));
        System.out.println("test2SqlSessionFactory:"+applicationContext.getBean("test2SqlSessionFactory"));
        // 注入的applicationContext其实是class org.springframework.web.context.support.GenericWebApplicationContext实现
        System.out.println("applicationContext:"+applicationContext.getClass());
    }
}
