package com.example.myproject5.dao;

import com.example.myproject5.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * 基本的CRUD框架已经实现
     */

    /**
     *简单的自定义查询：findBy[field][keyworld][field][keyworld]...
     * 关键字：And,Or,Is,Equals,Between,LessThan,LessThanEqual,GreaterThan,GreaterThanEqual,
     *        After,Before,IsNull,IsNotNull,NotNull,Like,NotLike,StartingWith,EndingWith,Containing,
     *        OrderBy,Not,In,NotIn,TRUE,FALSE,IgnoreCase
     */
    User findByNickName(String nickName);
    User findByUserNameAndNickName(String userName, String nickName);

    /**
     * 复杂查询
     * 1.分页。框架已经提供，通过构建Pageable对象实现分页
     * 2.限制查询
     * 3.自定义sql查询
     * 4.多表查询
     */
}

