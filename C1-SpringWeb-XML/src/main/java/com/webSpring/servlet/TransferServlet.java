package com.webSpring.servlet;

import com.webSpring.service.AccountService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TransferServlet extends HttpServlet {
    private AccountService accountService;

    @Override
    // 在init方法中获取Spring的IOC容器，只需要执行一次
    public void init() throws ServletException {
        System.out.println("✅ TransferServlet is working!");
        WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        accountService = (AccountService) context.getBean("accountService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("✅ TransferServlet is working!");
        accountService.transfer(1001L, 1002L, 1000.00);
    }
}
