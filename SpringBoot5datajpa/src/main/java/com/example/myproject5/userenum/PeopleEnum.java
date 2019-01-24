package com.example.myproject5.userenum;

/**
 * 两个构造参数
 */
public enum PeopleEnum {
    STUDENT("学生", 9),
    WORKER("工人", 8),
    FARMER("农民", 7);

    private String name;
    private Integer index;

    PeopleEnum(String type, Integer index) {
        this.name = type;
        this.index = index;
    }


    @Override
    public String toString() {
       return this.name+"_"+this.index;
    }

    public String getName() {
        return name;
    }

    public Integer getIndex() {
        return index;
    }}
