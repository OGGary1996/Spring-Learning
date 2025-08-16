package com.kezhang;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XMLBeanTest {
    public static void main(String[] args) {
        // 模拟采用ApplicationContext加载XML配置文件
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 从容器中获取UserController实例
        Object userController = context.getBean("userController");
        // 模拟调用UserController的方法
        // 。。。。。。。。
        // 模拟关闭IoC容器，触发销毁方法
        context.close();
    }
}
