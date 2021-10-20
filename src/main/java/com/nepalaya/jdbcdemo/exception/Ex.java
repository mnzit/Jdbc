package com.nepalaya.jdbcdemo.exception;

import com.nepalaya.jdbcdemo.util.LogUtil;

public class Ex {

    public static void caught(ExceptionWrapper wrapper) {
        try {
            wrapper.handle();
        } catch (Exception ex) {
            LogUtil.exception(ex);
        }
    }
}
