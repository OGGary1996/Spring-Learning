package com.springMVCRequestResponse.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.springMVCRequestResponse.service", "com.springMVCRequestResponse.dao","com.springMVCRequestResponse.pojo"})
public class RootContextConfig {

}
