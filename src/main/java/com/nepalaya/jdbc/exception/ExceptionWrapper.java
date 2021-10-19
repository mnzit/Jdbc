package com.nepalaya.jdbc.exception;

@FunctionalInterface
public interface ExceptionWrapper {
    void process() throws Exception;
}
