package com.nepalaya.jdbc.exception;

import com.nepalaya.jdbc.response.Response;

@FunctionalInterface
public interface ExceptionDataWrapper {
    Response handle() throws Exception;
}
