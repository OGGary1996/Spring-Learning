package com.springMVCFilterInterceptor.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.springMVCFilterInterceptor.service" , "com.springMVCFilterInterceptor.dao"})
public class RootContextConfig {
}
