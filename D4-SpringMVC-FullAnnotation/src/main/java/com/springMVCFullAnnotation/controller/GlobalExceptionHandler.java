package com.springMVCFullAnnotation.controller;

import com.springMVCFullAnnotation.result.Result;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice // = @ControllerAdvice + @ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(NoHandlerFoundException.class) // ExceptionHandlerExceptionResolver 处理404异常
    @ResponseStatus(HttpStatus.NOT_FOUND) // ResponseStatusExceptionResolver 处理404异常 + DefaultHandlerExceptionResolver 语义处理
    public Result<?> noHandlerFoundExceptionHandler(NoHandlerFoundException ex){
        System.out.println("Caught NoHandlerFoundException: " + ex.getMessage());
        return Result.failure("404 Error: " + ex.getMessage());
    }

    @ExceptionHandler(NullPointerException.class) // ExceptionHandlerExceptionResolver 处理空指针异常
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) //  ResponseStatusExceptionResolver 处理500异常 + DefaultHandlerExceptionResolver 语义处理
    public Result<?> nullPointerExceptionHandler(NullPointerException ex){
        System.out.println("Caught NullPointerException: " + ex.getMessage());
        return Result.failure("Null Pointer Error: " + ex.getMessage());
    }

    // 处理其他异常(兜底)
    @ExceptionHandler(Exception.class) // ExceptionHandlerExceptionResolver 处理其他异常
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // ResponseStatusExceptionResolver 处理500异常 + DefaultHandlerExceptionResolver 语义处理
    public Result<?> exceptionHandler(Exception ex){
        System.out.println("Caught Exception: " + ex.getMessage());
        return Result.failure("Internal Server Error: " + ex.getMessage());
    }
}
