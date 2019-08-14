package com.xr.util;

/**
 * 验证对象或者字符串是否为空
 */
public class Validation {
    private Validation(){}

    public static boolean isNoNull(Object object){
        if(object==null){
            return false;
        }
        if(object instanceof String){
            if(((String) object).trim().equals("")){
                return false;
            }
        }
        return true;
    }
}
