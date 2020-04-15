package com.datav.rule.exception;


import com.datav.rule.domain.EnumCode;
import org.apache.shiro.authc.AuthenticationException;


public class ShiroException  extends  AuthenticationException{

    private int  errCode = EnumCode.Unknown_Exception.getCode();

    public ShiroException(EnumCode code){
        super(code.getMessage());
        this.errCode = code.getCode();
    }

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }
}
