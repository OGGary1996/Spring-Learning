package com.transactionXml;

import com.transactionXml.entity.Account;
import com.transactionXml.service.AccountService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TransactionXmlTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService userService =(AccountService) context.getBean("accountService");

        userService.transfer(1001L,1002L,1000.0);

        List<Account> accountList = userService.list();
        accountList.forEach(System.out::println);

    }
}
