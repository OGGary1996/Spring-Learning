package com.springMVCFullAnnotation.config;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.util.Properties;

// 根容器配置
@Configuration
// 扫描service层
@ComponentScan(basePackages = {
        "com.springMVCFullAnnotation.service",
        "com.springMVCFullAnnotation.aop"})
// 读取db.properties配置文件
@PropertySource("classpath:db.properties")
// 扫描mapper接口
@MapperScan("com.springMVCFullAnnotation.mapper")
// aop
@EnableAspectJAutoProxy(proxyTargetClass = false) // 使用JDK动态代理，true则使用CGLib
// 事务
@EnableTransactionManagement
public class RootContextConfig {
    // 配置数据源
    @Bean
    public DataSource dataSource(
            @Value("${db.url}") String url,
            @Value("${db.username}") String username,
            @Value("${db.password}") String password,
            @Value("${db.driverClassName}") String driverClassName
    ) {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driverClassName);
        return dataSource;
    }
    // 配置SqlSessionFactory
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        // 其他配置：驼峰映射等
         // 注意是mybatis的Configuration类，不是Spring的
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true); // 开启驼峰映射
        factoryBean.setConfiguration(configuration);
        // 扫描实体类
        factoryBean.setTypeAliasesPackage("com.springMVCFullAnnotation.entity");
        return factoryBean.getObject();
    }
    // aop
    // @EnableAspectJAutoProxy + @Aspect 即可，注意需要扫描到aop的包

    // 配置事务管理器
    // @EnableTransactionManagement + DataSourceTransactionManager类 + @Transactional 即可
    @Bean
    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    // 配置异常处理器：本处以SimpleMappingExceptionResolver为例
    // SimpleMappingExceptionResolver需要手动配置
    @Bean
    public SimpleMappingExceptionResolver simpleMappingExceptionResolver() {
        SimpleMappingExceptionResolver exceptionResolver = new SimpleMappingExceptionResolver();
        // 配置exceptionMappings
        // 必须配置的属性
        Properties exceptionMappings = new Properties();
        exceptionMappings.setProperty("java.lang.ArithmeticException","error/arithmeticError"); // 算术异常
        exceptionMappings.setProperty("org.springframework.web.servlet.NoHandlerFoundException","error/404"); // 404异常
        exceptionMappings.setProperty("java.lang.NullPointerException","error/500"); // 空指
        exceptionMappings.setProperty("java.lang.Exception","error/500"); // 所有异常
        exceptionResolver.setExceptionMappings(exceptionMappings);
        // 配置对应的statusCode
        // 使得页面显示对应的状态码，而不是始终显示200，200表示网络请求成功，但不代表业务逻辑成功
        Properties statusCodes = new Properties();
        statusCodes.setProperty("error/arithmeticError",String.valueOf(HttpStatus.BAD_REQUEST.value())); // 400
        statusCodes.setProperty("error/404",String.valueOf(HttpStatus.NOT_FOUND.value())); // 404
        statusCodes.setProperty("error/500",String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value())); // 500
        exceptionResolver.setStatusCodes(statusCodes);
        // 设置defaultErrorView
        // 当没有匹配到具体异常时，默认的错误页面
        exceptionResolver.setDefaultErrorView("error/500");
        // 设置对应的defaultStatusCode
        exceptionResolver.setDefaultStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value()); // 500

        // 设置异常属性名
        exceptionResolver.setExceptionAttribute("ex"); // 在页面中通过${ex}获取异常
        // 设置order，值越小，优先级越高
        exceptionResolver.setOrder(10);
        return exceptionResolver;
    }

}
