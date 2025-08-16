package com.kezhang;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

public class BeanFactoryTest {
    public static void main(String[] args) {
        // 1. 创建BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 2. 创建Bean.xml的读取器，参数为BeanFactory，关联起来
        XmlBeanDefinitionReader xmlReader = new XmlBeanDefinitionReader(beanFactory);
        // 3. 读取配置文件到BeanFactory中
        xmlReader.loadBeanDefinitions("beans.xml");
        // 4. 获取Bean
        Object userServiceImpl = beanFactory.getBean("userServiceImpl");
        System.out.println(userServiceImpl);
    }
}
