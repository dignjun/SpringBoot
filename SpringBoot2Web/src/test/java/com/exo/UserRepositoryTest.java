package com.exo;

import com.example.myproject.Application;
import com.example.myproject.dao.UserRepository;
import com.example.myproject.user.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.DateFormat;
import java.util.Date;

/**
 * SpringBoot的单元测试使用
 * 1.@RunWith注解，
 * 2.@SpringBootTest注解
 * <p>
 * 注意：上面两个注解并不会加载@Component注解标识的配置。
 *       服务容器启动之后输出了filter的日志，但是测试并没有输出filter日志。
 */
@SpringJUnitConfig
@SpringBootConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void userRepositoryTest() {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String formatDate = dateFormat.format(date);
        userRepository.save(new User("aa1", "aa@126.com", "aa", "aa123456", formatDate));
        userRepository.save(new User("bb2", "bb@126.com", "bb", "bb123456", formatDate));
        userRepository.save(new User("cc3", "cc@126.com", "cc", "cc123456", formatDate));

        Assert.assertEquals(3, userRepository.findAll().size());
        Assert.assertEquals("bb123456", userRepository.findByUserNameOrEmail("bb2", "bb@126.com").getNickName());
        userRepository.delete(userRepository.findByUserName("aa1"));

    }
}
