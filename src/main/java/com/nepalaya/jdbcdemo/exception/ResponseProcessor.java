package com.nepalaya.jdbcdemo.exception;

import com.nepalaya.jdbcdemo.builder.ResponseBuilder;
import com.nepalaya.jdbcdemo.exception.ExceptionDataWrapper;
import com.nepalaya.jdbcdemo.response.Response;
import com.nepalaya.jdbcdemo.util.LogUtil;

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
