package com.example.MallManageSystem.exception;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class Response<T>{
    private T data;
    private String message;
    private HttpStatus statusCode;
}
