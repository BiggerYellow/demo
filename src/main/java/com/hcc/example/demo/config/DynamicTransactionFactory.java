package com.hcc.example.demo.config;

import org.apache.ibatis.session.TransactionIsolationLevel;
import org.apache.ibatis.transaction.Transaction;
import org.apache.ibatis.transaction.TransactionFactory;
import org.mybatis.spring.transaction.SpringManagedTransaction;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.Properties;


public class DynamicTransactionFactory implements TransactionFactory {

//    public DynamicTransactionFactory( HikariCustomConfig holder) {
//        this.holder = holder;
//    }

    @Override
    public void setProperties(Properties props) {

    }

    @Override
    public Transaction newTransaction(Connection conn) {
        throw new UnsupportedOperationException("New Spring transactions require a DataSource");
    }

    @Override
    public Transaction newTransaction(DataSource dataSource, TransactionIsolationLevel level, boolean autoCommit) {
        // 必须保证 AbstractRoutingDataSource的实现类也是用同一个数据源容器对象
        return new SpringManagedTransaction(dataSource);//从容器中获取当前切换到的数据源
    }
}
