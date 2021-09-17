package com.hcc.example.method;

/**
 * @author huangchunchen
 * @date 2021/7/26 16:03
 * @description
 */
public class test {
    public static void main(String[] args) {
        AbstractClass abstractClass = new ConcertClass();
        System.out.println(abstractClass.doSome("11", new MethodHelper()));
        System.out.println(abstractClass.doSome1(123, new MethodHelper()));
    }
}
