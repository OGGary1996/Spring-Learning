package com.aopXml.service.impl;

import com.aopXml.service.OrderService;

public class OrderServiceImpl implements OrderService {
    @Override
    public void generate() {
        System.out.println("OrderServiceImpl: Order generated started.");
        // 模拟耗时
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("OrderServiceImpl: Order generated completed.");
    }
}
