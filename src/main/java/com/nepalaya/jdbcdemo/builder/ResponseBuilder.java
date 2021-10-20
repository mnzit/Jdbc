package com.nepalaya.jdbcdemo.builder;

import com.nepalaya.jdbcdemo.response.Response;

public class ResponseBuilder {

    public static Response success(String message, Object object) {
        return Response
                .builder()
                .success(true)
                .message(message)
                .data(object)
                .build();
    }

    public static Response success(String message) {
        return Response
                .builder()
                .success(true)
                .message(message)
                .build();
    }

    public static Response failure(String message) {
        return Response
                .builder()
                .success(false)
                .message(message)
                .build();
    }
}
