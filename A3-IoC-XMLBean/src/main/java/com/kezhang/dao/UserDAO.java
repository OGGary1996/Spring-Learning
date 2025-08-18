package com.kezhang.dao;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import java.sql.Connection;
import java.sql.SQLException;

public class UserDAO implements InitializingBean, DisposableBean {
    // 无参构造器，在XML中，默认采用无参构造器创建对象
    // 承担了实例化的职责
    public UserDAO(){
        System.out.println("UserDAO: UserDAO instance created.");
    }
    // 依赖注入
    private DruidDataSource dataSource;
    public void setDataSource(DruidDataSource dataSource) {
        this.dataSource = dataSource;
        System.out.println("UserDAO: DataSource injected.");
    }

    public void initUserDAO(){
        System.out.println("UserDAO: init method called.");
    }
    public void destroyUserDAO(){
        System.out.println("UserDAO: destroy method called.");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("UserDAO: afterPropertiesSet method called from InitializingBean.");
    }
    @Override
    public void destroy() throws Exception {
        System.out.println("UserDAO: destroy method called from DisposableBean.");
    }

    public void insertUser() {
        // 模拟数据库插入操作
        try {
            Connection dataSourceConnection = dataSource.getConnection();
            System.out.println("UserDAO: Obtained connection: " + dataSourceConnection);
        } catch (SQLException e) {
            System.err.println("UserDAO: Error obtaining connection: " + e.getMessage());
        }
    }
}
