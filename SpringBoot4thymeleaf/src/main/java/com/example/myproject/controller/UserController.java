package com.example.myproject.controller;

import com.example.myproject.dao.UserRepository;
import com.example.myproject.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;
import java.util.Optional;

/**
 * 使用模版返回视图，所以不使用@RestController
 */
@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/getUser")
    public String getUserList(){
        List<User> list = userRepository.findAll();
        System.out.println(list);
        return "user";
    }

    @RequestMapping("/getUser/{id}")
    public String getUserById(@PathVariable("id") Long id){
        Optional<User> optionUser = userRepository.findById(id);
        User user = optionUser.get();
        return "index";
    }
}
