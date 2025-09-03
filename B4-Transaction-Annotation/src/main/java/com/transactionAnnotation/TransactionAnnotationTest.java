package com.transactionAnnotation;

import com.transactionAnnotation.config.AppConfig;
import com.transactionAnnotation.entity.Account;
import com.transactionAnnotation.service.AccountService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class TransactionAnnotationTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        AccountService service = (AccountService) context.getBean("accountService");
        service.transfer(1001L,1002L,1000.0);

        List<Account> accountList = service.list();
        accountList.forEach(System.out::println);
    }
}
