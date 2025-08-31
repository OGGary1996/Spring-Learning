package com.xmlbean.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

public class ToolB implements BeanFactoryAware {
    private String type;
    private Integer level;
    // 无参构造器，用于无参工厂方法构建
    public ToolB() {}

    // 有参构造器，用于有参工厂方法构建
    public ToolB(String Type,Integer level){
        this.type = Type;
        this.level = level;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryAware: BeanFactory is " + beanFactory.getClass().getName());
    }

    public void toolB(){
        // 模拟工具类方法
        System.out.println("Tool2: tool2 method called, " +
                "type: " + type + ", level: " + level);
    }
}
