package com.aopXml.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class LogAspect {
    // 前置通知
    public void before(){
        System.out.println("[LogAspect] before advice: Method is about to be executed.");
    }

    // 后置通知
    // 正常执行
    public void afterReturning(Object result){
        System.out.println("[LogAspect] afterReturning advice: Method executed successfully, returned: " + result);
    }
    // 异常执行
    public void afterThrowing(IllegalArgumentException exception){
        System.out.println("[LogAspect] afterThrowing advice: An exception occurred during method execution, exception: " + exception.getMessage());
    }
    // 最终通知
    public void after(){
        System.out.println("[LogAspect] after advice: Method execution completed (either normally or with exception).");
    }

    // 环绕通知
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("[LogAspect] around advice: Before method execution.");
        Object result = null;
        try {
            result = joinPoint.proceed();
            System.out.println("[LogAspect] around advice: After method execution.");
            return result;
        } catch(Throwable t){
            System.out.println("[LogAspect] around advice: Exception caught during method execution.");
            throw t;
        }finally {
            System.out.println("[LogAspect] around advice: Finally block executed after method execution.");
        }
    }


}
