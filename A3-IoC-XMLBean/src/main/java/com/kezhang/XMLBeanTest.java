package com.kezhang;

import com.kezhang.controller.OrderController;
import com.kezhang.controller.UserController;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XMLBeanTest {
    public static void main(String[] args) {
        // 模拟采用ApplicationContext加载XML配置文件
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 从容器中获取UserController实例
        UserController userController = (UserController) context.getBean("userController");
        OrderController orderController = (OrderController) context.getBean("orderController");
        // 模拟调用Controller的方法
        userController.saveUser();
        orderController.createOrder();
        // 模拟关闭IoC容器，触发销毁方法
        context.close();
    }
}
