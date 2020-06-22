package com.example.GlobalExceptionHandler.domain;

import lombok.Data;

@Data
public class ErrorDto {
    private String timestamp;
    private String status;
    private String errorMessage;
}
