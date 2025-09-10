package com.springMVCFullAnnotation.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptorDemo implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 在请求处理之前进行拦截,核心，决定是否放行
        System.out.println("MyInterceptorDemo preHandle...");
        String requestURI = request.getRequestURI();
        System.out.println("Intercepting request URI: " + requestURI);
        // 返回true表示放行，返回false表示拦截
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // 在请求处理之后，视图渲染之前进行拦截,如果方法报错，不会执行
        System.out.println("MyInterceptorDemo postHandle...");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 在整个请求处理完毕，视图渲染之后进行拦截，无论如何都会执行
        System.out.println("MyInterceptorDemo afterCompletion...");
    }
}
