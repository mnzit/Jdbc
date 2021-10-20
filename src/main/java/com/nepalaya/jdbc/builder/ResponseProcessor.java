package com.nepalaya.jdbc.builder;

import com.nepalaya.jdbc.exception.Ex;
import com.nepalaya.jdbc.exception.ExceptionDataWrapper;
import com.nepalaya.jdbc.response.Response;
import com.nepalaya.jdbc.util.LogUtil;

public class ResponseProcessor {

    public static Response process(ExceptionDataWrapper exceptionDataWrapper){
        try{
            return exceptionDataWrapper.handle();
        }catch (Exception ex){
            LogUtil.exception(ex);
            return ResponseBuilder.failure(ex.getMessage());
        }
    }
}
