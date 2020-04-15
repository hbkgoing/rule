package com.datav.rule.util;

import com.datav.rule.domain.EnumCode;
import com.datav.rule.domain.ServiceStatus;

/**
 * Created by BKhe on 2020/2/26/22:32.
 */
public class ResponseUtil {

    /**
     * success callback
     * @param object
     * @return
     */
    public static ServiceStatus success(Object object){
        ServiceStatus response = new ServiceStatus(EnumCode.SUCCESS.getCode(),EnumCode.SUCCESS.getMessage(),object);
        return response;

    }

    /**
     * error callback
     * @param code
     * @param message
     * @return
     */
    public static ServiceStatus error(Integer code , String message){
        ServiceStatus response = new ServiceStatus(code,message);
        return response;
    }
}
