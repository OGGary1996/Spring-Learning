package com.aopAnnotation.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
    // Pointcut
    @Pointcut("execution(* com.aopAnnotation.service.impl..*(..))")
    void serviceMethods(){};

    // Advice (before, after, around, afterReturning, afterThrowing)
    @Before("serviceMethods()")
    public void before(){
        System.out.println("[LogAspect] before advice: Method is about to be executed.");
    }
    @AfterReturning(pointcut="serviceMethods()", returning="result")
    public void afterReturning(Object result){
        System.out.println("[LogAspect] afterReturning advice: Method executed successfully, returned: " + result);
    }
    @AfterThrowing(pointcut="serviceMethods()", throwing="ex")
    public void afterThrowing(Throwable ex){
        System.out.println("[LogAspect] afterThrowing advice: An exception occurred during method execution, exception: " + ex.getMessage());
    }
    @After("serviceMethods()")
    public void after(){
        System.out.println("[LogAspect] after advice: Method execution completed (either normally or with exception).");
    }
    @Around("serviceMethods()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("[LogAspect] around advice: Before method execution.");
        Object result = null;
        try {
            result = joinPoint.proceed();
            System.out.println("[LogAspect] around advice: After method execution.");
            return result;
        }catch(Throwable t){
            System.out.println("[LogAspect] around advice: Exception caught during method execution, exception: " + t.getMessage());
            throw t;
        }finally {
            System.out.println("[LogAspect] around advice: Finally block executed after method execution.");
        }
    }

}
