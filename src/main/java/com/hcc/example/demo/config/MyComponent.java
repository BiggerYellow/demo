package com.hcc.example.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author huangchunchen
 * @date 2021/9/7 16:05
 * @description
 */
@Component
public class MyComponent {

    public static final Logger logger = LoggerFactory.getLogger(MyComponent.class);

    public void test(){
        logger.info("----------------------------");
    }
}
