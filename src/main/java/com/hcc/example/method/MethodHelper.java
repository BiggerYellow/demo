package com.hcc.example.method;

import org.springframework.lang.Nullable;

/**
 * @author huangchunchen
 * @date 2021/7/26 15:55
 * @description
 */
public class MethodHelper {

    public String replacePlaceholders(String value, TestFunction testFunction) {
        return testFunction.test1(value);
    }


    public String replacePlaceholders1(TestFunction1 testFunction1) {
        return testFunction1.test2();
    }


    @FunctionalInterface
    public interface TestFunction{
        @Nullable
        String test1(String name);
    }


    @FunctionalInterface
    public interface TestFunction1{
        @Nullable
        String test2();
    }
}
