package com.annotationBean.service.impl;

import com.annotationBean.dao.UserDAO;
import com.annotationBean.service.UserService;
import com.annotationBean.utils.Tool;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("userService")
@Scope("singleton")
@Lazy(false)
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;
    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
        System.out.println("UserServiceImpl: constructor with UserDAO called");
    }
    private Tool tool;
    @Autowired
    @Qualifier("toolB")
    public void setTool(Tool tool){
        this.tool = tool;
        System.out.println("UserServiceImpl: setTool called");
    }

    @PostConstruct
    public void initMethod() {
        System.out.println("UserServiceImpl initMethod called");
    }
    @PreDestroy
    public void destroyMethod() {
        System.out.println("UserServiceImpl destroyMethod called");
    }

    @Override
    public void selectByIds() {
        userDAO.selectByIds();
        tool.tool();
    }
}
