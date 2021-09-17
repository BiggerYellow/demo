package com.hcc.example.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA
 *
 * @author : 18070910
 * @Date :   2019/7/24
 * @Time :  9:46
 * @Description :
 */
@Component
@Aspect
public class DataSourceAspect {

    private final Logger logger = LoggerFactory.getLogger(DataSourceAspect.class);

    @Pointcut("execution(* com.hcc.example.demo.service.impl.*.*(..))")
    public void aspect() {}


    /**
     * 配置前置通知,使用在方法aspect()上注册的切入点
     */
    @Before("aspect()")
    public void before(JoinPoint point) {
        Object[] args = point.getArgs();
        try {
            String sandBox = Integer.toString((int)args[0]);
            if (sandBox.equals("1")){
                HandleDataSource.putDataSource(DataSourceType.SANDBOX.getType());
            }else {
                HandleDataSource.putDataSource(DataSourceType.INSTANCE.getType());
            }
        } catch (Exception e) {
            logger.error(e.toString());
            HandleDataSource.putDataSource(DataSourceType.INSTANCE.getType());
        }
    }

    @After("aspect()")
    public void after(JoinPoint point) {
        HandleDataSource.clear();
    }
}
