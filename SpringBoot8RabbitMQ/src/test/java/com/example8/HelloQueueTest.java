package com.example8;

import com.example8.process.HelloSender;
import com.example8.process.HelloSender12;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class HelloQueueTest {

    @Autowired
    private HelloSender helloSender;
    @Autowired
    private HelloSender12 helloSender12;

    /**
     * 一对一
     */
    @Test
    public void helloTest() {
        helloSender.send();
    }

    /**
     * 一对多
     */
    @Test
    public void hello12Test(){
        helloSender12.send();
    }

    /**
     * 路由模式
     */
    @Test
    public void helloTopicTest(){
        helloSender.send1();
        helloSender.send2();
    }

    /**
     * 广播模式或订阅模式
     */
    @Test
    public void helloFanoutTest(){
        helloSender.send3();
    }

}
