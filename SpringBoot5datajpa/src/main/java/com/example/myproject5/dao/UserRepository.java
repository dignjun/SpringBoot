package com.example.myproject5.dao;

import com.example.myproject5.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

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

    /**
     * 限制查询
     */
    User findTopByUserName(String userName);

    /**
     * 自定义sql，自定义sql中需要注意的是原生sql还是hql
     */
//    @Modifying 这个注解用来标识是create,update,modify的,查询不能使用
    // hql
    @Query(value = "select u  from User u where u.userName = ?1",nativeQuery = false)
    User findByUserName(String userName);
    // sql
    @Query(value = "select * from user where user_name = ?1",nativeQuery = true)
    User findByUserName2(String userName);

    /**
     * 多表查询
     */
    //定义结果集接口--接口中提供查询结果的字段的get方法--自定义sql--返回结果集使用Page<自定义结果集接口>
    //spring会生成一个动态代理来接受结果集。


}

