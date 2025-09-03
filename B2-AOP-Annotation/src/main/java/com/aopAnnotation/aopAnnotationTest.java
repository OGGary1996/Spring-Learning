package com.aopAnnotation;

import com.aopAnnotation.config.AppConfig;
import com.aopAnnotation.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class aopAnnotationTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService =(UserService) context.getBean("userService");
        userService.register("admin");
    }
}
