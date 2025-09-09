package com.springMVCFilterInterceptor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/demo")
public class DemoController {
    @GetMapping("/filter-interceptor")
    public String hello() {
        System.out.println("DemoController hello() method invoked");
        return "demo";
    }
}
