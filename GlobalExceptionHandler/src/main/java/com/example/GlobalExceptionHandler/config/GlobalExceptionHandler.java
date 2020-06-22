package com.example.GlobalExceptionHandler.config;

import com.example.GlobalExceptionHandler.domain.ErrorDto;
import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    //ResponseStatus
    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ErrorDto> generateResponseStatusException(ResponseStatusException rse){
        ErrorDto errorDto = new ErrorDto();
        errorDto.setTimestamp(new Date().toString());
        //.getStatus() -> output : HttpStatus
        //.value() -> output : int
        errorDto.setStatus(String.valueOf(rse.getStatus().value()));
        errorDto.setErrorMessage(rse.getMessage());
        //notice how we directly invoke log
        log.error("Exception Occurred : ",rse);
        //return new ResponseEntity<T> with errorDto, rse.getStatus()
        return new ResponseEntity<>(errorDto,rse.getStatus());

    }

    //NotFound - 404
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorDto> generateNotFoundException(NotFoundException nfe){
        ErrorDto errorDto = new ErrorDto();
        errorDto.setTimestamp(new Date().toString());
        //.getStatus() -> output : HttpStatus
        //.value() -> output : int
        errorDto.setStatus("404");
        errorDto.setErrorMessage(nfe.getMessage());
        //notice how we directly invoke log
        log.error("Exception Occurred : ",nfe);
        //return new ResponseEntity<T> with errorDto, rse.getStatus()
        return new ResponseEntity<>(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //RunTime - 500
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorDto> generateRunTimeException(RuntimeException rte){
        ErrorDto errorDto = new ErrorDto();
        errorDto.setTimestamp(new Date().toString());
        //.getStatus() -> output : HttpStatus
        //.value() -> output : int
        errorDto.setStatus("500");
        errorDto.setErrorMessage(rte.getMessage());
        //notice how we directly invoke log
        log.error("Exception Occurred : ",rte);
        //return new ResponseEntity<T> with errorDto, rse.getStatus()
        return new ResponseEntity<>(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }



}
