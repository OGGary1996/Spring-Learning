package com.xmlbean.service.impl;

import com.xmlbean.dao.OrderDAO;
import com.xmlbean.service.OrderService;

public class OrderServiceImpl implements OrderService {
    // 无参构造器
    public OrderServiceImpl(){
        System.out.println("OrderServiceImpl: OrderServiceImpl instance created.");
    }
    // 模拟注入OrderDAO,这里采用Setter注入方式
    private OrderDAO orderDAO;
    public void setOrderDAO(OrderDAO orderDAO){
        this.orderDAO = orderDAO;
        System.out.println("OrderServiceImpl: OrderDAO injected successfully.");
    }

    // 省略初始化和销毁方法

    @Override
    public void placeOrder() {
        orderDAO.insertOrder();
        System.out.println("OrderServiceImpl: placeOrder method executed.");
    }
}
