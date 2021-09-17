package com.hcc.example.demo.vo;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class User {
    private Integer id;
    private String userName;
    private String passWord;
    private String realName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public User(Integer id) {
        this.id = id;
    }

    public User() {
    }

    public User(Integer id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", realName='" + realName + '\'' +
                '}';
    }

    public static void main(String[] args) {

        BiFunction<Integer, String, User> runnable = User::new;

        Function<Integer, User> runnable1 = User::new;
        User apply = runnable1.apply(1);
        System.out.println(apply);
        List<Integer> integers = Arrays.asList(1, 2);
        Stream<User> userStream = integers.stream().map(User::new);
//        integers.stream().forEach(a->{
//            Runnable runnable = User::new;
//        });


    }
}
