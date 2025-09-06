package com.springMVCXml.controller;

import com.springMVCXml.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public void addUser() {
        userService.addUser();
        System.out.println("UserController addUser ...");
    }
}
