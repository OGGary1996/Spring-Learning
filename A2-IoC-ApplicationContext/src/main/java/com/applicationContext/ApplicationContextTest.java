package com.applicationContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextTest {
    public static void main(String[] args) {
        // 1.创建ApplicationContext
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 2. 即使不获取Bean，也会触发Bean的初始化
        // 显示UserDAO注入时的提示信息
        // If you see this msg, it means UserDAO has been injected successfully.

    }
}
