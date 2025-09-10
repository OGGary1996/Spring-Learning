package com.springMVCFullAnnotation.controller;

import com.springMVCFullAnnotation.entity.Account;
import com.springMVCFullAnnotation.result.Result;
import com.springMVCFullAnnotation.service.DemoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

 // @RestController = @Controller + @ResponseBody
 // 为了返回json数据，需要使用@ResponseBody注解，否则会被视图解析器处理，找对应的视图名称
@RestController
@RequestMapping("/demo")
public class DemoController {
    private final DemoService demoService;
    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    // http://localhost:8080/demo/account
    @GetMapping("/account")
    public Result<List<Account>> list(){
        System.out.println("Controller called...");
        List<Account> accountList = demoService.list();
        System.out.println("Account list: " + accountList);
        return Result.success(accountList);
    }

    // 模拟ArithmeticException
    @GetMapping("/error/arithmetic")
    public Result<?> errorArithmetic() {
        Integer a = 1 / 0;
        return Result.failure(null);
    }
    // 模拟NullPointerException
    @GetMapping("/error/null-pointer")
    public Result<?> errorNullPointer() {
        String str = null;
        str.length();
        return Result.failure(null);
    }
    // 模拟其他异常
    @GetMapping("/error/other")
    public Result<?> errorOther() throws Exception {
        throw new Exception("Simulated Exception");
    }

    // 局部异常处理
    @ExceptionHandler(ArithmeticException.class) // 处理算术异常
    @ResponseStatus(HttpStatus.BAD_REQUEST) // 设置响应状态码为400
    public Result<?> arithmeticExceptionHandler(ArithmeticException ex){
        System.out.println("Caught ArithmeticException: " + ex.getMessage());
        return Result.failure("Arithmetic Error: " + ex.getMessage());
    }
}
