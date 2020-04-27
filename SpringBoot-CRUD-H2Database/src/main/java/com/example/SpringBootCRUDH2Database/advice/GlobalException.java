package com.example.SpringBootCRUDH2Database.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalException {
    //This class handles specific exception
    @ExceptionHandler(ResourceNotFoundException.class)
    //ResponseEntity with any (?) input data type
    public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException resourceNotFoundException, WebRequest webRequest){
        //invoking ErrorDetails
        //.getDescription(boolean b) -> output : String
        ErrorDetails errorDetails = new ErrorDetails(new Date(), resourceNotFoundException.getMessage(), webRequest.getDescription(false));
        System.out.println("specific exception");
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    //This class handles global exception
    @ExceptionHandler(Exception.class)
    //ResponseEntity with any (?) input data type
    public ResponseEntity<?> globalExceptionHandler(Exception exception, WebRequest webRequest){
        //invoking ErrorDetails
        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), webRequest.getDescription(false));
        System.out.println("global exception");
        return  new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
