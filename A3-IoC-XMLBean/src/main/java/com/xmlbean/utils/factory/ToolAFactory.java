package com.xmlbean.utils.factory;

import com.xmlbean.utils.ToolA;

public class ToolAFactory {
    // 静态工厂方法
    // 无参工厂方法
    public static ToolA createToolA(){
        System.out.println("ToolAFactory: createToolA method called.");
        return new ToolA();
    }
    // 有参工厂方法
    public static ToolA createToolAWithArgs(String type,Integer level){
        System.out.println("ToolAFactory: createToolAWithArgs method called.");
        return new ToolA(type, level);
    }
}
