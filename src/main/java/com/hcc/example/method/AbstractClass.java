package com.hcc.example.method;

import org.springframework.lang.Nullable;

/**
 * @author huangchunchen
 * @date 2021/7/26 15:53
 * @description
 */
public abstract class AbstractClass {

    public String doSome(String text, MethodHelper helper) {
        return helper.replacePlaceholders(text, this::test);
    }


    public String doSome1(int text, MethodHelper helper) {
        return helper.replacePlaceholders1(() -> {
            return test2(text);
        });
    }


    @Nullable
    public abstract String test(String name);

    @Nullable
    public abstract String test2(int text);
}
