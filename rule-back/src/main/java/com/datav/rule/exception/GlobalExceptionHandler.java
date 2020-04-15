package com.datav.rule.exception;




import com.datav.rule.domain.ServiceStatus;
import org.apache.shiro.authc.pam.UnsupportedTokenException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * handler global Exception then throw to front
 */

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = DomainException.class)
    public ServiceStatus domainExceptionHandler(HttpServletRequest req, DomainException e) throws Exception{
        ServiceStatus serviceStatus = new ServiceStatus(e.getErrCode(),e.getMessage());
        return serviceStatus;
    }

    @ExceptionHandler(value = ShiroException.class)
    public ServiceStatus shiroExceptionHandler(HttpServletRequest request, HttpServletResponse response , ShiroException e)throws Exception{
        ServiceStatus serviceStatus = new ServiceStatus(e.getErrCode(),e.getMessage());
        return serviceStatus;
    }

    @ExceptionHandler(value = UnsupportedTokenException.class)
    public ServiceStatus UnsupportedTokenException(HttpServletRequest request, HttpServletResponse response, Exception e) {
        return null;
    }

}
