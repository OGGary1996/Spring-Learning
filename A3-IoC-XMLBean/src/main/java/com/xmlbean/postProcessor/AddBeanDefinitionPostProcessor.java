package com.xmlbean.postProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;

public class AddBeanDefinitionPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        // 强转beanFactory为DefaultListableBeanFactory，以便使用 注册BeanDefinition的方法
        DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) beanFactory;

        // 1. 添加OrderService的Bean定义
        GenericBeanDefinition orderServiceBeanDefinition = new GenericBeanDefinition();
            // 1.1 设置Bean的类名
        orderServiceBeanDefinition.setBeanClassName("com.xmlbean.service.impl.OrderServiceImpl");
            // 1.2 设置Bean的作用域
        orderServiceBeanDefinition.setScope("singleton");
        // 若构造器有参数，可使用 ConstructorArgumentValues：
        // ConstructorArgumentValues cav = new ConstructorArgumentValues();
        // cav.addIndexedArgumentValue(0, "arg0");
        // bd.setConstructorArgumentValues(cav);
            // 1.3 设置属性，等同于<property name="orderDAO" ref="orderDAO" />
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.add("orderDAO", new RuntimeBeanReference("orderDAO"));
        orderServiceBeanDefinition.setPropertyValues(propertyValues);
        // 2. 注册OrderServiceImpl的Bean定义
        defaultListableBeanFactory.registerBeanDefinition("orderServiceImpl", orderServiceBeanDefinition);
        System.out.println("BeanFactoryPostProcessor: OrderService bean definition has been added.");

        // 3. 添加OrderController的Bean定义
        GenericBeanDefinition orderControllerBeanDefinition = new GenericBeanDefinition();
            // 3.1 设置Bean的类名
        orderControllerBeanDefinition.setBeanClassName("com.xmlbean.controller.OrderController");
            // 3.2 设置Bean的作用域
        orderControllerBeanDefinition.setScope("singleton");
            // 3.3 设置构造器参数，等同于<constructor-arg index="0" ref="orderService" />
        ConstructorArgumentValues cav = new ConstructorArgumentValues();
        cav.addIndexedArgumentValue(0, new RuntimeBeanReference("orderServiceImpl"));
        orderControllerBeanDefinition.setConstructorArgumentValues(cav);
        // 4. 注册OrderController的Bean定义
        defaultListableBeanFactory.registerBeanDefinition("orderController", orderControllerBeanDefinition);
        System.out.println("BeanFactoryPostProcessor: OrderController bean definition has been added.");
    }
}
