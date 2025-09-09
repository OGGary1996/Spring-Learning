package com.springMVCRequestResponse.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "com.springMVCRequestResponse.controller")
@EnableWebMvc
public class WebContextConfig implements WebMvcConfigurer {
    // 配置视图解析器
    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    // 配置文件上传的解析器
    @Bean
    public CommonsMultipartResolver multipartResolver(){
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        // 设置上传文件的最大值
        multipartResolver.setMaxUploadSize(10 * 1024 * 1024);// 10MB
        // 设置单个文件大小的最大值
        multipartResolver.setMaxUploadSizePerFile(5 * 1024 * 1024);// 5MB
        // 设置编码
        multipartResolver.setDefaultEncoding("UTF-8");
        return multipartResolver;
    }

    // 配置静态资源的处理器
    // 注意：必须要启用@EnableWebMvc注解，否则会Spring不会注册自己的handler
     // 1. 等同于 <mvc:resources mapping="/请求路径/**" location="/资源路径/"/>
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/")
//                .addResourceLocations("/resources/")
//                .addResourceLocations("/WEB-INF/views/");
//    }

     // 2. 等同于 <mvc:default-servlet-handler/>
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
