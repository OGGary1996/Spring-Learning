package com.beanFactory.service.impl;

import com.beanFactory.dao.UserDAO;
import com.beanFactory.service.UserService;

public class UserServiceImpl implements UserService {
    // 模拟注入UserDAO,采用setter注入方式
    private UserDAO userDAO;
    public void setUserDAO(UserDAO userDAO){
        this.userDAO = userDAO;
        System.out.println("If you see this msg, it means UserDAO has been injected successfully.");
    }

    @Override
    public void saveUser() {
        // 模拟保存用户
        userDAO.insertUser();
        System.out.println("UserServiceImpl: Saved user successfully.");
    }
}
