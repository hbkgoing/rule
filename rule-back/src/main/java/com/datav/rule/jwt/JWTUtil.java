package com.datav.rule.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.datav.rule.domain.EnumCode;
import com.datav.rule.exception.DomainException;
import com.datav.rule.exception.ShiroException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;

public class JWTUtil {

    private final  static  Logger logger = LoggerFactory.getLogger(JWTUtil.class);

    @Autowired
    static HttpServletRequest request;
    /**
     * sign token
     * @param username
     * @param secret
     * @return
     */
    public static  String sign(String username,String secret){
        try {
//            Date date = new Date(System.currentTimeMillis() );
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer( username)
//                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (Exception e) {
            logger.error("算法签名失败："+e);
            return null;
        }
    }

    /**
     * check sign
     * @param token
     * @param username
     * @param secret
     * @return
     */
    public static boolean verify(String token, String username, String secret ) throws ShiroException{
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer(username)
                    .build();
            verifier.verify(token);
            return  true;
        }catch (Exception e){
            throw  new ShiroException(EnumCode.USER_NOT_LGOIN);
        }
    }

    public static  String getUsername(String token){
        try{
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getIssuer();
        }catch (JWTDecodeException e){
            logger.error("令牌解析失败："+e);
            throw new ShiroException(EnumCode.TOKEN_VERIFY_FAILD);
        }
    }
}
