package com.hcc.example.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author huangchunchen
 * @date 2021/1/14 8:47
 * @description
 */
public class MyApplicationListener implements ApplicationListener<ApplicationStartingEvent> {

    private static final Logger log = LoggerFactory.getLogger(MyApplicationListener.class);

    @Override
    public void onApplicationEvent(ApplicationStartingEvent event) {
        log.info("-------------------------------");
    }
}
