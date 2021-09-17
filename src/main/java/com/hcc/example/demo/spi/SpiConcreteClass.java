package com.hcc.example.demo.spi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author huangchunchen
 * @date 2021/9/2 19:14
 * @description
 */
public class SpiConcreteClass implements SpiBaseInterface{

    public static final Logger logger = LoggerFactory.getLogger(SpiConcreteClass.class);

    @Override
    public void test() {
        logger.info("---------invoke ------");
    }
}
