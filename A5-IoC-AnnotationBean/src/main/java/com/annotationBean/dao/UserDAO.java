package com.annotationBean.dao;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository("userDAO")
@Lazy(false)
@Scope("singleton")
public class UserDAO {

    @PostConstruct
    public void initMethod(){
        System.out.println("UserDAO: initMethod called");
    }
    @PreDestroy
    public void destroyMethod(){
        System.out.println("UserDAO: destroyMethod called");
    }

    public void selectByIds(){
        System.out.println("UserDAO: selectByIds called" );
    }
}
