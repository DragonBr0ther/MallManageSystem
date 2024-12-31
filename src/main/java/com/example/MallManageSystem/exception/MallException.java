package com.example.MallManageSystem.exception;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class MallException extends Exception{
    private String message;
    private HttpStatus statusCode;
}
