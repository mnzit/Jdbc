package com.nepalaya.jdbcdemo.exception;

import com.nepalaya.jdbcdemo.response.Response;

@FunctionalInterface
public interface ExceptionDataWrapper {
    Response handle() throws Exception;
}
