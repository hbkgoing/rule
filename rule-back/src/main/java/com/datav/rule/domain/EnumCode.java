package com.datav.rule.domain;

/**
 *   Enumerate  all response's code&message
 *
 */

public enum EnumCode {

    SUCCESS(2000,"请求成功"),

    Unknown_Exception(-1,"未知异常"),

    USER_NOT_FOUND(1001,"未找到用户"),
    USER_AUTH_FAILD(1002, "用户认证失败"),
    USER_NOT_LGOIN(1003,"用户未登陆"),
    VCODE_VERIFY_FAILD(1004,"验证码错误"),

    TOKEN_NOT_FOUND(3003,"未找到令牌"),
    TOKEN_VERIFY_FAILD(3001,"令牌校验失败"),
    TOKEN_CREATE_FAILD(3002,"令牌生成失败"),

    SMC_API_FAILD(5001,"能力开放平台接口调用失败");

    private Integer code;
    private String message;

    EnumCode(Integer code,String message){
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
