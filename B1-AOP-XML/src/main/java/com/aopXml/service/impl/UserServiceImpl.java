package com.aopXml.service.impl;

import com.aopXml.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public void register(String username) {
        // 模拟异常
        if (username.trim().equalsIgnoreCase("username")){
            throw new IllegalArgumentException("Username is invalid.");
        }
        // 正常执行
        System.out.println("UserServiceImpl: User " + username + " registered successfully.");
    }
}
