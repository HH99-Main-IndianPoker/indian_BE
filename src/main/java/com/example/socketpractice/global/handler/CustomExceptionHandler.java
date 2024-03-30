package com.example.socketpractice.global.handler;

import com.example.socketpractice.global.dto.ResponseDto;
import com.example.socketpractice.global.handler.exception.CustomApiException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseDto<?> handleCustomApiException(CustomApiException e) {
        return ResponseDto.fail(e.getMessage());
    }
}
