package com.hcc.example.demo.config;

import com.hcc.example.demo.aop.DataSourceType;
import com.hcc.example.demo.aop.DynamicDataSource;
import com.zaxxer.hikari.HikariDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class HikariCustomConfig {

    public static final Logger logger = LoggerFactory.getLogger(HikariCustomConfig.class);

    @Value("${mybatis.mapper-locations}")
    private String configLocation;
    @Value("${mybatis.type-aliases-package}")
    private String typeAliasespackage;

    @Bean("instance")
    @ConfigurationProperties(prefix = "spring.datasource.instance")
    public HikariDataSource masterDataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean("sandbox")
    @ConfigurationProperties(prefix = "spring.datasource.sandbox")
    public HikariDataSource slaveDataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean(name = "dynamicDataSource")
    public DynamicDataSource dataSource(@Qualifier("instance") DataSource masterDataSource, @Qualifier("sandbox") DataSource slaveDataSource) {
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DataSourceType.INSTANCE.getType(), masterDataSource);
        targetDataSources.put(DataSourceType.SANDBOX.getType(), slaveDataSource);
        return new DynamicDataSource(masterDataSource, targetDataSources);
    }

    /**
     * @description: 配置mybatis的mapper和dao的位置
     */
    @Bean("sqlSessionFactoryBean")
    public SqlSessionFactoryBean sqlSessionFactoryBean(@Qualifier("dynamicDataSource") DynamicDataSource dynamicDataSource) throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dynamicDataSource);
        sqlSessionFactoryBean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources(configLocation));
        sqlSessionFactoryBean.setTypeAliasesPackage(typeAliasespackage);
        return sqlSessionFactoryBean;
    }

    /**
     * 事务管理
     */
    @Bean
    public PlatformTransactionManager transactionManager(@Qualifier("dynamicDataSource") DynamicDataSource dynamicDataSource) {
        return new DataSourceTransactionManager(dynamicDataSource);
    }

}
