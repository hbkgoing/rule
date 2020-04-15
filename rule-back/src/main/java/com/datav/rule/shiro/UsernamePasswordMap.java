package com.datav.rule.shiro;

import java.util.HashMap;
import java.util.Map;


/**
 * maintain secret，if logout then change secret to 'logout' by username. if login then put password
 */
public class UsernamePasswordMap {

    public static Map<String,String> upMap = new HashMap();
}
