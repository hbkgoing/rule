package com.datav.rule.controller;


import com.alibaba.fastjson.JSON;
import com.datav.rule.domain.ServiceStatus;
import com.datav.rule.util.ResponseUtil;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;


/**
 * 对controller进行增强
 */
@RestControllerAdvice(basePackages = {"com.datav.rule.controller"})
public class ResponseControllerAdvice implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return !methodParameter.getGenericParameterType().equals(ServiceStatus.class);
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {

        if (methodParameter.getGenericParameterType().equals(String.class)) {
            String result = JSON.toJSONString(ResponseUtil.success(o));
            return result;
        }

        return ResponseUtil.success(o);
    }
}
