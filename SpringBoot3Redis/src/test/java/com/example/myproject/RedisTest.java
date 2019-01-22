package com.example.myproject;

import com.example.myproject3.Application3;
import com.example.myproject3.dao.UserRepository;
import com.example.myproject3.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application3.class)
public class RedisTest {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private UserRepository userRepository;

    @Test
    public void redisTest() {
        stringRedisTemplate.opsForValue().set("aaa", "111");
        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
    }

    /**
     * 手动设置缓存
     * @throws InterruptedException
     */
    @Test
    public void testObj() throws InterruptedException {
        String date = DateFormat.getDateInstance().format(new Date());
        User user = new User("123@163.com","an","123",date,"Jan");
        ValueOperations<String, User> options = redisTemplate.opsForValue();
        options.set("com.example", user);
        options.set("com.example.w", user, 10, TimeUnit.SECONDS);
//        redisTemplate.delete("com.example.w");
//        Thread.sleep(1000l);
        Boolean boo = redisTemplate.hasKey("com.example.w");
        if (boo) {
            System.out.println("exists is true");
        } else {
            System.out.println("exists is false");
        }
    }

    /**
     * 一般都是在查询数据库的时候自动使用缓存的。如下配置@Cacheable。
     * value值表示的是存入到缓存中的key，值就是返回的结果。
     */
//    @Test
//    @Cacheable(value = "user-key")
//    public void testAuto(){
//        User aa1 = userRepository.findByUserName("aa1");
//        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
//        System.out.println(aa1);
//    }
}
