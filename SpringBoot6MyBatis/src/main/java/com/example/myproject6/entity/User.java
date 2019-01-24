package com.example.myproject6.entity;


import java.io.Serializable;

public class User implements Serializable {

    private Long id;
    private String email;
    private String nickName;
    private String passWord;
    private String regTime;
    private String userName;

    public User() {

    }

    public User(String email, String nickName, String passWord, String regTime, String userName) {
        this.email = email;
        this.nickName = nickName;
        this.passWord = passWord;
        this.regTime = regTime;
        this.userName = userName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getRegTime() {
        return regTime;
    }

    public void setRegTime(String regTime) {
        this.regTime = regTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", nickName='" + nickName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", regTime='" + regTime + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
