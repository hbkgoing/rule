package com.datav.rule.exception;


import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import java.util.Map;

/**
 * handle the Exception\Error in Servlet
 */
@RestController
public class ErrorController extends BasicErrorController {

    public ErrorController() {
        super(new DefaultErrorAttributes(), new ErrorProperties());
    }

    @Override
    @RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
        Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");
        Map map =this.getErrorAttributes(request, this.isIncludeStackTrace(request, MediaType.ALL));
        if (exception == null) {
            throw new DomainException(map.toString());
        }else {
            if (exception.getCause() instanceof ShiroException) {
                ShiroException e = (ShiroException) exception.getCause();
                throw e;
            } else {
                throw new  DomainException(exception.toString());
            }
        }
    }


}

