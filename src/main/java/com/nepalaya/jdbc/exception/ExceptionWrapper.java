package com.nepalaya.jdbc.exception;

@FunctionalInterface
public interface ExceptionWrapper {
    void handle() throws Exception;
}
