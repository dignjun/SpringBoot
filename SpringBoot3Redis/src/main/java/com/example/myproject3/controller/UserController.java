package com.example.myproject3.controller;

import com.example.myproject3.dao.UserRepository;
import com.example.myproject3.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    /**
     * 一般都是在查询数据库的时候自动使用缓存的。如下配置@Cacheable。
     *
     * @return User json字符串
     */
    @RequestMapping("/getUser")
//    @Cacheable(value = "user-key")
    public User getUser(){
        User user = userRepository.findByUserName("aa1");
        System.out.println("若下面没出现“无缓存调用的时候”字样且能打印出数据表示测试成功");
        return user;
    }
}
