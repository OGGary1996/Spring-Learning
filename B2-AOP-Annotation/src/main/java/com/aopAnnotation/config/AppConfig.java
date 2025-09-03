package com.aopAnnotation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"com.aopAnnotation"})
@EnableAspectJAutoProxy(proxyTargetClass = false ,exposeProxy = false) // false: JDK dynamic proxy, true: CGLIB proxy
public class AppConfig {
}
