package com.kezhang.utils;

public class ToolC {
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

    public void toolC() {
        // 模拟业务方法
        System.out.println("ToolC: toolC method called, " +
                "host: " + host + ", port: " + port);
    }
}
