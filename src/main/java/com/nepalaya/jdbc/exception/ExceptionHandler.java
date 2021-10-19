package com.nepalaya.jdbc.exception;

import com.nepalaya.jdbc.builder.ResponseBuilder;
import com.nepalaya.jdbc.response.Response;
import com.nepalaya.jdbc.util.LogUtil;

public class ExceptionHandler {

    public static void handle(ExceptionWrapper wrapper) {
        try {
            wrapper.process();
        } catch (Exception ex) {
            LogUtil.exception(ex);
        }
    }
}
