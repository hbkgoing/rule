package com.datav.rule.controller;

import com.alibaba.fastjson.JSONObject;
import com.datav.rule.config.cas.CASServiceUtil;
import com.datav.rule.config.cas.XmlUtils;
import com.datav.rule.domain.EnumCode;
import com.datav.rule.domain.User;
import com.datav.rule.exception.DomainException;
import com.datav.rule.jwt.JWTUtil;
import com.datav.rule.shiro.UsernamePasswordMap;
import com.datav.rule.util.ResponseUtil;
import io.swagger.annotations.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@Api(tags = "登陆接口")
@RequestMapping(value = "/user")
public class LoginController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @ApiOperation("用户登录获取令牌")
    @PostMapping("login")
    @ApiImplicitParam(name = "user", value = "用户名、密码", required = true,paramType="body",
            examples = @Example({
            @ExampleProperty(mediaType = "username",value = "admin"),
            @ExampleProperty(mediaType= "password",value="123456")
    }))
    public String login(@RequestBody @Validated JSONObject user,HttpServletRequest request) {

        HttpServletRequest req = request;
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals("kaptchaId")) {
                    String vCode = stringRedisTemplate.opsForValue().get(cookies[i].getValue());
                    if (user.getString("Vcode").equals(vCode)) {
                        String userName = user.getString("username");
                        String password = user.getString("password");
                        UsernamePasswordMap.upMap.put(userName, password);
                        //TODO: DB check username password
                        String token = JWTUtil.sign(userName, password);
                        return token;
                    } else {
                        throw new DomainException(EnumCode.VCODE_VERIFY_FAILD);
                    }
                }
            }
        }
        throw new DomainException(EnumCode.VCODE_VERIFY_FAILD);
    }


    @ApiOperation("获得用户信息")
    @GetMapping(value = "/info")
    public User getInfo(@RequestParam String token) {
        String username = JWTUtil.getUsername(token);
        User user = new User();
        user.setName(username);
        List roles = new ArrayList();
        roles.add(username);
        user.setRoles(roles);
        user.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        user.setIntroduction("admin 用户");
        return user;

    }


    @Value("cas.prefixUrl")
    private String prefixUrl;

    /**
     * check cas st
     *
     * @param ticket
     * @param service
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @GetMapping("/validateLogin")
    public Object validateLogin(@RequestParam(name = "ticket") String ticket,
                                @RequestParam(name = "service") String service,
                                HttpServletRequest request,
                                HttpServletResponse response) throws Exception {

        JSONObject jsonObject = new JSONObject();
        try {
            String validateUrl = prefixUrl + "/p3/serviceValidate";
            String res = CASServiceUtil.getSTValidate(validateUrl, ticket, service);
//            log.info("res."+res);
            final String error = XmlUtils.getTextForElement(res, "authenticationFailure");
            if (StringUtils.isNotEmpty(error)) {
                throw new Exception(error);
            }
            final String principal = XmlUtils.getTextForElement(res, "user");
            if (StringUtils.isEmpty(principal)) {
                throw new Exception("No principal was found in the response from the CAS server.");
            }
            System.out.println("-------token----username---" + principal);
            //1. 校验用户是否有效
//            SysUser sysUser = sysUserService.getUserByName(principal);
//            result = sysUserService.checkUserIsEffective(sysUser);
//            if(!result.isSuccess()) {
//                return result;
//            }
            String token = JWTUtil.sign(principal, principal);
            UsernamePasswordMap.upMap.put(principal, principal);
            // 设置超时时间
//            redisUtil.set(CommonConstant.PREFIX_USER_TOKEN + token, token);
//            redisUtil.expire(CommonConstant.PREFIX_USER_TOKEN + token, JwtUtil.EXPIRE_TIME*2 / 1000);
            //获取用户部门信息

            jsonObject.put("token", token);
            jsonObject.put("username", principal);

            return ResponseUtil.success(token);


        } catch (Exception e) {
            //e.printStackTrace();
            ResponseUtil.error(500, e.getMessage());
        }
        return new HttpEntity<>(ResponseUtil.success(jsonObject));
    }

}
