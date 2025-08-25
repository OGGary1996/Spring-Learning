package com.kezhang.postProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class CustomBeanDefinitionPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        // 将UserDAO和OrderDAO中的scope属性值改为singleton
        // 1. 获取UserDAO,OrderDAO的BeanDefinition
        BeanDefinition userDAODefinition = beanFactory.getBeanDefinition("userDAO");
        BeanDefinition orderDAODefinition = beanFactory.getBeanDefinition("orderDAO");
        // 2. 修改scope属性值
        userDAODefinition.setScope(BeanDefinition.SCOPE_SINGLETON); // 动态修改为singleton
        System.out.println("BeanFactoryPostProcessor: UserDAO scope has been modified: " + userDAODefinition.getScope());
        orderDAODefinition.setScope(BeanDefinition.SCOPE_SINGLETON); // 动态修改为singleton
        System.out.println("BeanFactoryPostProcessor: OrderDAO scope has been modified: " + orderDAODefinition.getScope());
    }
}
