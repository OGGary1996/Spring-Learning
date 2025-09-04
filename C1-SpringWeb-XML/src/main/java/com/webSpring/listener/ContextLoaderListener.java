//package com.webSpring.listener;
//
//import com.webSpring.config.AppConfig;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//import javax.servlet.ServletContext;
//import javax.servlet.ServletContextEvent;
//import javax.servlet.ServletContextListener;
//import javax.servlet.annotation.WebListener;
//
//public class ContextLoaderListener implements ServletContextListener {
//    private AnnotationConfigApplicationContext applicationContext;
//
//    @Override
//    public void contextInitialized(ServletContextEvent sce) {
//        System.out.println("✅ ContextLoaderListener is working!");
//        // 创建Spring的IOC容器
//        applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
//        // 将IOC容器存入ServletContext域中,全局共享
//        ServletContext servletContext = sce.getServletContext();
//        servletContext.setAttribute("applicationContext", applicationContext);
//    }
//
//    @Override
//    public void contextDestroyed(ServletContextEvent sce) {
//        System.out.println("❌ ContextLoaderListener is destroyed!");
//        // 关闭IOC容器
//        if (applicationContext != null) {
//            applicationContext.close();
//        }
//    }
//}
