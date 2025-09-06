package com.springMVCXml.service.impl;

import com.springMVCXml.dao.UserDAO;
import com.springMVCXml.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;
    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void addUser() {
        userDAO.insertUser();
        System.out.println("UserServiceImpl addUser...");
    }
}
