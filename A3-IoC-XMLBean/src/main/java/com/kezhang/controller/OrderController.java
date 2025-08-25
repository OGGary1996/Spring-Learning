package com.kezhang.controller;

import com.kezhang.service.OrderService;

public class OrderController {
    // 模拟注入OrderService,这里采用构造器注入方式
    private final OrderService orderServiceImpl;
    // 同时承担了实例化、依赖注入的职责
    public OrderController(OrderService orderServiceImpl){
        this.orderServiceImpl = orderServiceImpl;
        System.out.println("OrderController: OrderService injected successfully.");
    }

    // 忽略初始化方法和销毁方法的实现

    // 业务方法
    public void createOrder() {
        orderServiceImpl.placeOrder();
        // 模拟创建订单
        System.out.println("OrderController: Order created successfully.");
    }

}
