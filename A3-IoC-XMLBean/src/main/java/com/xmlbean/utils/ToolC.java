package com.xmlbean.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ToolC implements ApplicationContextAware {
    private String host;
    private Integer port;
    // 无参构造器，用于无参工厂方法构建
    public ToolC() {
    }
    // 有参构造器，用于有参工厂方法构建
    public ToolC(String host, Integer port) {
        this.host = host;
        this.port = port;
    };

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("ApplicationContextAware: ApplicationContext is " + applicationContext.getClass().getName());
    }

    public void toolC() {
        // 模拟业务方法
        System.out.println("ToolC: toolC method called, " +
                "host: " + host + ", port: " + port);
    }
}
