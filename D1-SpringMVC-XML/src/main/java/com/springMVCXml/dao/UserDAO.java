package com.springMVCXml.dao;

import org.springframework.stereotype.Repository;

@Repository("userDAO")
public class UserDAO {
    public void insertUser() {
        System.out.println("UserDAO insertUser...");
    }
}
