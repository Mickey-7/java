package com.example.GlobalExceptionHandler.controller;

public class NotFoundException extends RuntimeException {
    NotFoundException(String string){
        super(string);
    }
}
