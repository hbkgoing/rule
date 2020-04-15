package com.datav.rule.jwt;

import com.datav.rule.domain.EnumCode;


import com.datav.rule.exception.ShiroException;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;



public class JWTFilter extends BasicHttpAuthenticationFilter {


    private static final String TOKEN = "Authentication";

    private final Logger logger = LoggerFactory.getLogger(JWTFilter.class);

    /**
     * check  that  request header whether has token
     *
     * @param request
     * @param response
     * @param mappedValue
     * @return
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        executeLogin(request, response);
        return true;
    }

    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) {
        HttpServletRequest req = (HttpServletRequest) request;
        String token = req.getHeader(TOKEN);
        if (!StringUtils.isEmpty(token) && token!=null) {
            JWTToken jwtToken = new JWTToken(token);
            getSubject(request, response).login(jwtToken);
        } else {
            throw new ShiroException(EnumCode.TOKEN_NOT_FOUND);
        }
        return true;
    }

}
