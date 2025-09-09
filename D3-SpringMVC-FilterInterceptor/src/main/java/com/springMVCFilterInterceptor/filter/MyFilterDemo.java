package com.springMVCFilterInterceptor.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(urlPatterns = "/*", filterName = "myFilterDemo")
public class MyFilterDemo implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 可以不必重写
        System.out.println("MyFilterDemo init...");
    }

    @Override
    public void destroy() {
        // 可以不必重写
        System.out.println("MyFilterDemo destroy...");
    }

    // 实现过滤器的核心方法
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("MyFilterDemo doFilter...");
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletRequest resp = (HttpServletRequest) request;
        // 示例：打印请求的URI
        String requestURI = req.getRequestURI();
        System.out.println("Filtering request URI: " + requestURI);
        // 放行
        chain.doFilter(request, response);
    }
}
