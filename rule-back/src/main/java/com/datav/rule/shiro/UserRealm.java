package com.datav.rule.shiro;

import com.datav.rule.domain.EnumCode;
import com.datav.rule.exception.DomainException;
import com.datav.rule.exception.ShiroException;
import com.datav.rule.jwt.JWTToken;
import com.datav.rule.jwt.JWTUtil;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.pam.UnsupportedTokenException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * self-realm， implement authentication，authorization。
 */

public class UserRealm extends AuthorizingRealm {



    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }


    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }
    /**
     * check sign by token，query userinfo by DB
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)  {
        String jwtToken = (String)token.getCredentials();
        String username =JWTUtil.getUsername(jwtToken);
        String password = UsernamePasswordMap.upMap.get(username);
        //TODO: DB query userinfo
        JWTUtil.verify(jwtToken,username,password);
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                username,
                jwtToken,
                getName()
        );
        return authenticationInfo;
    }
}
