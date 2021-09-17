package com.hcc.example.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author huangchunchen
 * @date 2021/9/2 16:52
 * @description
 */
public class MyApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    private static final Logger log = LoggerFactory.getLogger(MyApplicationListener.class);


    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        log.info("invoke MyApplicationContextInitializer");
    }
}
