package com.example;

import com.example.myproject5.userenum.ColorEnum;
import com.example.myproject5.userenum.PeopleEnum;
import com.example.myproject5.userenum.UserTypeEnum;
import org.junit.Test;

/**
 * 枚举测试
 */
public class EnumTest {
    /**
     * 枚举的基本使用
     */
    @Test
    public void colorEnumTest(){
        ColorEnum[] values = ColorEnum.values();
        System.out.println("values:"+values);
        for (ColorEnum color :
                values) {
            System.out.println("value:"+color.name()+"index:"+color.ordinal());
        }
        System.out.println("--------------------");
        String name = ColorEnum.RED.name();
        int ordinal = ColorEnum.RED.ordinal();
        System.out.println("name:"+name+",ordinal:"+ordinal);
    }

    /**
     * 一个构造参数
     */
    @Test
    public void userTest(){
        UserTypeEnum[] values = UserTypeEnum.values();
        for (UserTypeEnum userType :
                values) {
            System.out.println("name:"+userType.name()+",order:"+userType.ordinal());
        }
//        name:STUDENT,order:0
//        name:TEACHER,order:1
//        name:MASTER,order:2
        System.out.println(UserTypeEnum.MASTER);
    }

    /**
     * 两个构造参数
     */
    @Test
    public void peopleEnumTest(){
        PeopleEnum[] values = PeopleEnum.values();
        for (PeopleEnum people :
                values) {
            System.out.println(people.name()+":"+people.ordinal());
        }
        System.out.println("------------");
        for (PeopleEnum people :
                values) {
            System.out.println(people.getName()+":"+people.getIndex());
        }
    }
}
