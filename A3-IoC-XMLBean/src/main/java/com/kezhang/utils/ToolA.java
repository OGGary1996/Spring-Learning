package com.kezhang.utils;

public class ToolA {
    private String type;
    private Integer level;
    // 无参构造器,用于无参工厂方法构建
    public ToolA(){

    }
    // 有参构造器，用于有参工厂方法构建
    public ToolA(String type,Integer level){
        this.type = type;
        this.level = level;
    }


    public void toolA() {
        System.out.println("Tool1: tool1 method called, " +
                "type: " + type + ", level: " + level);
    }
}
