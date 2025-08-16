package com.kezhang.dao;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class UserDAO implements InitializingBean, DisposableBean {
    // 无参构造器，在XML中，默认采用无参构造器创建对象
    // 承担了实例化的职责
    public UserDAO(){
        System.out.println("UserDAO: UserDAO instance created.");
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

    public void insertUser(){
        // 模拟保存用户
        System.out.println("UserDAO: User inserted successfully.");
    }
}
