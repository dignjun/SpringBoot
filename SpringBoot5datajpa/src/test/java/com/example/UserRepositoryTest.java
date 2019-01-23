package com.example;

import com.example.myproject5.Application;
import com.example.myproject5.dao.UserRepository;
import com.example.myproject5.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    /**
     * spring data jpa 中提供了CRUD基本的数据库的操作方法。默认的方法。
     */
    @Test
    public void crudTest(){
        List<User> list = userRepository.findAll();
        System.out.println(list);
    }
    /**
     * 自定义方法
     */
    @Test
    public void cusTest(){
        User us = userRepository.findByNickName("cc123456");
        System.out.println(us);
        User user = userRepository.findByUserNameAndNickName("cc3", "cc123456");
        System.out.println(user);
    }
}
