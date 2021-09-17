package com.hcc.example.demo;

import java.util.Objects;
import java.util.ServiceLoader;
import java.util.Set;

import com.hcc.example.demo.config.HikariCustomConfig;
import com.hcc.example.demo.config.MyComponent;
import com.hcc.example.demo.service.DemoService;
import com.hcc.example.demo.spi.SpiBaseInterface;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.index.CandidateComponentsIndex;
import org.springframework.context.index.CandidateComponentsIndexLoader;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@MapperScan("com.hcc.example.demo.mapper")
@SpringBootApplication
//@SpringBootApplication(exclude = AopAutoConfiguration.class)
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
//@Import({HikariCustomConfig.class})
//@EnableTransactionManagement
//@EnableAspectJAutoProxy
public class DemoApplication {


    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
        //"META-INF/spring.components"
//        CandidateComponentsIndex candidateComponentsIndex = CandidateComponentsIndexLoader.loadIndex(DemoApplication.class.getClassLoader());
//        if (Objects.nonNull(candidateComponentsIndex)){
//            Set<String> candidates = candidateComponentsIndex.getCandidateTypes("com.hcc.example", "org.springframework.stereotype.Component");
//            for (String candidate:candidates){
//                if (candidate.contains("MyComponent")){
//                    MyComponent myComponent = (MyComponent)context.getBeanFactory().getBean("myComponent");
//                    myComponent.test();
//                }
//            }
//        }
    }

//    public static void main(String[] args) {
////        ServiceLoader<SpiBaseInterface> spiBaseInterfaces = ServiceLoader.load(SpiBaseInterface.class);
////        spiBaseInterfaces.forEach(x->{
////            x.test();
////        });
//
//        //"META-INF/spring.components"
//        CandidateComponentsIndex candidateComponentsIndex = CandidateComponentsIndexLoader.loadIndex(DemoApplication.class.getClassLoader());
//        Set<String> candidates = candidateComponentsIndex.getCandidateTypes("com.hcc.example", "org.springframework.stereotype.Component");
//        System.out.println(candidates);
//    }

}



