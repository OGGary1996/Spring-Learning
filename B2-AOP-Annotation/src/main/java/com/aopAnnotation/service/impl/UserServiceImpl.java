package com.aopAnnotation.service.impl;

import com.aopAnnotation.service.UserService;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Override
    public void register(String username) {
        if (username.trim().equalsIgnoreCase("username")){
            throw new IllegalArgumentException("Invalid username");
        }
        System.out.println("User " + username + " registered successfully.");
    }
}
