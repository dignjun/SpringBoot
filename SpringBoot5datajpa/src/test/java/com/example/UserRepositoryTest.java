package com.example;

import com.example.myproject5.Application;
import com.example.myproject5.dao.UserRepository;
import com.example.myproject5.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
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
    public void crudTest() {
        List<User> list = userRepository.findAll();
        System.out.println(list);
    }

    /**
     * 自定义方法
     */
    @Test
    public void cusTest() {
        User us = userRepository.findByNickName("cc123456");
        System.out.println(us);
        User user = userRepository.findByUserNameAndNickName("cc3", "cc123456");
        System.out.println(user);
    }

    /**
     * 复杂查询
     */
    @Test
    public void complicatedTest() {
        //分页查询
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        PageRequest pageRequest = new PageRequest(1, 1, sort);
        Page<User> pageable = userRepository.findAll(pageRequest);
        ArrayList<User> list = new ArrayList<>();
        for (User user :
                pageable) {
            list.add(user);
        }
        System.out.println("-----------------分页查询---------------");
        System.out.println(list);
        System.out.println("-----------------分页查询---------------");

        // 限制查询。查询前N条数据，或第一条数据。
        //使用命名规则方式查询
//        User findFirstByOrderByLastnameAsc();
//        User findTopByOrderByAgeDesc();
//        Page<User> queryFirst10ByLastname(String lastname, Pageable pageable);
//        List<User> findFirst10ByLastname(String lastname, Sort sort);
//        List<User> findTop10ByLastname(String lastname, Pageable pageable);

        // 自定义sql
        User cc3 = userRepository.findByUserName("cc3");
        User cc4 = userRepository.findByUserName2("cc3");
        System.out.println("-----------------自定义sql---------------");
        System.out.println(cc3);
        System.out.println(cc4);
        System.out.println("-----------------自定义sql---------------");

    }

}
