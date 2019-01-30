package com.example;

import com.example.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class MailTest {
    @Autowired
    private MailService mailService;
    @Test
    public void mailSendTest() {
        mailService.sendSimpleMail("dingjun941035104@163.com","test","simple email");
    }
}
