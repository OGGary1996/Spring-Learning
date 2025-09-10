package com.springMVCFullAnnotation.result;

public class Result<T> {
    private Integer code;
    private String message;
    private T data;

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    // 成功返回方法
    public static <T> Result<T> success(T data){
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setMessage("Success");
        result.setData(data);
        return result;
    }
    // 失败返回方法
    public static <T> Result<T> failure(T data){
        Result<T> result = new Result<>();
        result.setCode(500);
        result.setMessage("Failure");
        result.setData(data);
        return result;
    }
}
