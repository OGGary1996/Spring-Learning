package com.aopXml.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.time.LocalDateTime;

public class TimeAspect implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        LocalDateTime start = LocalDateTime.now();
        System.out.println("[TimeAspect] Method " + invocation.getMethod().getName() + " start time: " + start);
        Object result = invocation.proceed();
        LocalDateTime end = LocalDateTime.now();
        System.out.println("[TimeAspect] Method " + invocation.getMethod().getName() + " end time: " + end);
        return result;
    }
}
