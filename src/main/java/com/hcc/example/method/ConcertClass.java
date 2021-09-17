package com.hcc.example.method;

/**
 * @author huangchunchen
 * @date 2021/7/26 15:53
 * @description
 */
public class ConcertClass extends AbstractClass{
    @Override
    public String test(String name) {
        return name;
    }

    @Override
    public String test2(int text) {
        return String.valueOf(text);
    }
}
