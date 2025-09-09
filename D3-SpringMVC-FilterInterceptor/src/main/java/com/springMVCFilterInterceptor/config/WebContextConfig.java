package com.springMVCFilterInterceptor.config;

import com.springMVCFilterInterceptor.interceptor.MyInterceptorDemo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = {
        "com.springMVCFilterInterceptor.controller" ,
        "com.springMVCFilterInterceptor.interceptor" ,
        "com.springMVCFilterInterceptor.filter"})
@EnableWebMvc
public class WebContextConfig implements WebMvcConfigurer {
    // 配置视图解析器、静态资源处理等
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
    // 配置文件上传的解析器
    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setMaxUploadSize(10*1024*1024); // 10MB
        resolver.setMaxUploadSizePerFile(2*1024*1024); // 2MB
        resolver.setDefaultEncoding("UTF-8");
        return resolver;
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

    // 配置拦截器
    // 等同于 <mvc:interceptors><mvc:interceptor>...</mvc:interceptors>


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptorDemo())
                .addPathPatterns("/**") // 拦截所有请求
                .excludePathPatterns("/static/**", "/css/**", "/js/**", "/images/**"); // 排除静态资源

    }
}
