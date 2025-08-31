package com.annotationMyBatis;

import com.annotationMyBatis.config.AppConfig;
import com.annotationMyBatis.service.PositionService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationMyBatisTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        PositionService service =(PositionService) context.getBean("positionServiceImpl");
        service.list();
        context.close();
    }
}
