package com.xmlbean.controller;

import com.xmlbean.service.UserService;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class UserController implements InitializingBean, DisposableBean {
    // 模拟注入UserService,这里采用构造器注入方式
    private final UserService userServiceImpl;
    // 有参构造器，由于XML中默认采用无参构造器创建对象，这里需要在XML中指定使用有参构造器，也就是<constructor-arg>标签
    // 同时承担了实例化、依赖注入的职责
    public UserController(UserService userServiceImpl){
        this.userServiceImpl = userServiceImpl;
        System.out.println("UserController: UserService injected successfully.");
    }

    public void initUserController(){
        System.out.println("UserController: init method called.");
    }
    public void destroyUserController(){
        System.out.println("UserController: destroy method called.");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("UserController: destroy method called from DisposableBean.");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("UserController: afterPropertiesSet method called from InitializingBean.");
    }

    public void saveUser() {
        userServiceImpl.saveUser();
        // 模拟保存用户
        System.out.println("UserController: User saved successfully.");
    }
}
