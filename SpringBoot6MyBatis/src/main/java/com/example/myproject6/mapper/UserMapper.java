package com.example.myproject6.mapper;

import com.example.myproject6.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//@Mapper//已经在启动类上添加mapper扫描了
public interface UserMapper {
    @Select("select * from user")
    List<User> list();
}
