package com.annotationBean;

import com.annotationBean.config.AppConf;
import com.annotationBean.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
// import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanTest {
    public static void main(String[] args) {
        // 不使用XML的方式创建Spring容器
        // ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 使用注解的方式创建Spring容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConf.class);
        UserService userService =(UserService) context.getBean("userService");
        userService.selectByIds();

        context.close();
    }
}
