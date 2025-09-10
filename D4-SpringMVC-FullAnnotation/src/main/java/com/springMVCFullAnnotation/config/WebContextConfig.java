package com.springMVCFullAnnotation.config;

import com.springMVCFullAnnotation.interceptor.MyInterceptorDemo;
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
        "com.springMVCFullAnnotation.controller",
        "com.springMVCFullAnnotation.filter",
        "com.springMVCFullAnnotation.interceptor"})
@EnableWebMvc
public class WebContextConfig implements WebMvcConfigurer {
    // 配置视图解析器
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
    // 配置文件上传解析器
    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("UTF-8");
        resolver.setMaxUploadSize(10485760); // 10MB
        resolver.setMaxUploadSizePerFile(2 * 1024 * 1024); // 2MB
        return resolver;
    }
    // 配置静态资源处理器
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

    // 配置Filter
    // xml配置在web.xml中，手动配置，全注解直接在Filter中使用@WebFilter注解即可；SpingBoot中可用@Bean配置

    // 配置拦截器
    // 等同于 <mvc:interceptors><mvc:interceptor>...</mvc:interceptors>
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptorDemo())
                .addPathPatterns("/**") // 拦截所有请求
                .excludePathPatterns("/login", "/error"); // 排除登录和错误页面
    }
}
