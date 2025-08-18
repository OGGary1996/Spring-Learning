package com.kezhang.dao;

import java.sql.Connection;

public class OrderDAO {
    public OrderDAO() {
        System.out.println("OrderDAO: OrderDAO instance created.");
    }

    // 依赖注入
    public Connection connection;
    public void setConnection(Connection connection) {
        this.connection = connection;
        System.out.println("OrderDAO: Connection injected.");
    }

    // 省略初始化方法和销毁方法的实现

    // 模拟订单插入操作
    public void insertOrder(){
        // 模拟数据库插入操作
        System.out.println("OrderDAO: Inserting order with connection: " + connection);
    }

}
