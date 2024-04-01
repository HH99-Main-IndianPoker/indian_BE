package com.example.socketpractice.global.exception;

import lombok.Getter;

@Getter
public class RestApiException extends RuntimeException {

    public RestApiException(String msg) {
        super(msg);
    }
}