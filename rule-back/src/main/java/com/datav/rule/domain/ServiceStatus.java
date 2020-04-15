package com.datav.rule.domain;

public class ServiceStatus<T> {

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    private T data;

    public ServiceStatus(Integer code, String message, T data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ServiceStatus(Integer code , String message){
        this.code = code;
        this.message = message;
    }
}
