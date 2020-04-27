package com.example.SpringBootCRUDH2Database.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception{
    private long serialVersionUID = 1L;

    public ResourceNotFoundException(String message) {
        super(message);
    }

}
