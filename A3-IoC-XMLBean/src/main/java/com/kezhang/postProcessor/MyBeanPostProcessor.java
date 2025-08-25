package com.kezhang.postProcessor;

import com.kezhang.service.impl.OrderServiceImpl;
import com.kezhang.service.impl.UserServiceImpl;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        // 可以在这里对bean进行一些处理
        // 例如，打印日志
        if(bean instanceof UserServiceImpl || bean instanceof OrderServiceImpl){
            System.out.println("MyBeanPostProcessor: Before Initialization of UserServiceImpl and OrderServiceImpl" );
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("userServiceImpl") || beanName.equals("orderServiceImpl")){
            System.out.println("MyBeanPostProcessor: After Initialization of UserServiceImpl and OrderServiceImpl");
        }
        return bean;
    }
}
