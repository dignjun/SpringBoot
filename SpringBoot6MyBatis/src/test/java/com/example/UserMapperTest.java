package com.example;

import com.example.myproject6.Application;
import com.example.myproject6.entity.User;
import com.example.myproject6.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void userMapperTest(){
        List<User> list = userMapper.list();
        System.out.println(list);
    }
}
