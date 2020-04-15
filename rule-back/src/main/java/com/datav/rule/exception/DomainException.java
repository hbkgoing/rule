package com.datav.rule.exception;


import com.datav.rule.domain.EnumCode;

public class DomainException extends  RuntimeException{

    private int errCode = EnumCode.Unknown_Exception.getCode();

    public DomainException(){
        super(EnumCode.Unknown_Exception.getMessage());
    }

    public DomainException(EnumCode code){
        super(code==null? "未知错误" : code.getMessage());
        this.errCode = code == null? -1 : code.getCode();
    }

    public DomainException(String message) {
        super(message==null ? "未知错误":message);
    }

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errorCode) {
        this.errCode = errorCode;
    }
}
