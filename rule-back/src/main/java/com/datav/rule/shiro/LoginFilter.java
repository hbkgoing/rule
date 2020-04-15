package com.datav.rule.shiro;

import com.datav.rule.domain.EnumCode;
import com.datav.rule.exception.ShiroException;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.servlet.OncePerRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Configuration
public class LoginFilter extends AccessControlFilter {

    @Autowired
    StringRedisTemplate stringRedisTemplate;


    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        HttpServletRequest req = (HttpServletRequest) request;
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals("kaptchaId")) {
                    stringRedisTemplate.opsForValue().get(cookies[i].getValue());
                }
            }
        } else {
            req.getRequestDispatcher("/user/login").forward(req,response);
        }

        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        return false;
    }
}
