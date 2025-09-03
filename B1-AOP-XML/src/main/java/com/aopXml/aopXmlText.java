package com.aopXml;

import com.aopXml.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class aopXmlText {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) context.getBean("userService");
        // 测试正常执行
        userService.register("admin");

        // 测试异常执行
//        try {
//            userService.register("username");
//        } catch (Exception e) {}

    }
}
