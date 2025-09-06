package com.springMVCXml.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.springMVCXml.service","com.springMVCXml.dao"})
public class RootContextConfig {
}
