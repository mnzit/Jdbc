package com.nepalaya.jdbcdemo.exception;

@FunctionalInterface
public interface ExceptionWrapper {
    void handle() throws Exception;
}
