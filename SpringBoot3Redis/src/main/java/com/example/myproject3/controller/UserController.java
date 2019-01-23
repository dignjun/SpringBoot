package com.example.myproject3.controller;

import com.example.myproject3.dao.UserRepository;
import com.example.myproject3.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.UUID;

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
    @Cacheable(value = "user-key")
    public User getUser(){
        User user = userRepository.findByUserName("bb2");
        return user;
    }

    @RequestMapping("/getUser2")
    @Cacheable(value = "user-key2")
    public User getUser2(){
        User user = userRepository.findByUserName("cc3");
        return user;
    }

    @RequestMapping("/getUser3")
    @Cacheable(key = "user-key3")
    public User getUser3(){
        User user = userRepository.findByUserName("bb2");
        return user;
    }

    @RequestMapping("/getUser4")
    @Cacheable(cacheNames = "getUser3")
    public User getUser4(){
        User user = userRepository.findByUserName("cc3");
        return user;
    }
    /**
     * 加上@Cacheable注解之后会缓存方法请求的结果，缓存key就是value的值。再次读取则是通过缓存获取，不再查询数据库
     * 注意：此时缓存的信息数据格式有点蒙，平常的缓存数据格式是string，list，set，zset，hash。
     *      但是通过注解存储的信息是一个namespace，/user-key/.(1)/user-key::SimpleKey[]
     *
     */

    /**
     * session共享的使用
     */
    @RequestMapping("/uid")
    public String getUid(HttpSession session){
        UUID uuid = (UUID) session.getAttribute("uid");
        if(uuid ==null){
            uuid = UUID.randomUUID();
            session.setAttribute("uid", uuid);
        }
        return session.getId();
    }

    /**
     * 只需要配置好spring-session-data-redis的maven依赖，和redis的依赖，请求自动将session
     * 缓存到redis中，文件目录是spring/sessions/expirations|sessions/
     *
     * 如何在两台或者多台中共享session的思考：
     * 同样配置，再配一遍即可，也就是使用相同的配置和同一个缓存即可达到目的。
     *
     */

}
