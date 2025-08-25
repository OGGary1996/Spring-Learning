package com.kezhang.postProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class TimeLogBeanPostProcessor implements BeanPostProcessor {
    // 模拟一个记录时间的BeanPostProcessor
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        // 判断是否需要记录时间
        if (!beanName.equals("userServiceImpl") && !beanName.equals("orderServiceImpl")){
            return bean;
        }
        // 如果需要记录时间，返回一个代理对象
        Object proxyInstance = Proxy.newProxyInstance(
                bean.getClass().getClassLoader(),
                bean.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    long startTime = System.currentTimeMillis();
                    Object result = method.invoke(bean, args);
                    long endTime = System.currentTimeMillis();
                    System.out.println("TimeLogBeanPostProcessor: " + beanName + " method " + method.getName() + " took " + (endTime - startTime) + " ms");
                    return result;
                }
        );
        return proxyInstance;
    }
}
