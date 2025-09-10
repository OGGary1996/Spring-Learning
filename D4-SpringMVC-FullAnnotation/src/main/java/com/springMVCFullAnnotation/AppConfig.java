package com.springMVCFullAnnotation;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

// web.xml的替代类
// web.xml中配置的内容都可以在这个类中进行配置
// 需要继承AbstractAnnotationConfigDispatcherServletInitializer
// 该类会在web容器启动时被自动加载
public class AppConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    // 配置根容器配置类
    // 等同于<context-param>中的contextConfigLocation
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{com.springMVCFullAnnotation.config.RootContextConfig.class};
    }

    // 配置web容器配置类
    // 等同于<servlet>中的init-param
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{com.springMVCFullAnnotation.config.WebContextConfig.class};
    }

    // 配置DispatcherServlet的映射信息
    // 等同于<servlet-mapping>中的url-pattern
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"}; // 所有请求
    }
}
