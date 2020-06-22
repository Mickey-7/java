package com.example.GlobalExceptionHandler.controller;

import com.example.GlobalExceptionHandler.domain.Student;
import com.example.GlobalExceptionHandler.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class StudentController {
    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/test")
    public String sayHello(){
        //invoke RunTimeException
        throw new RuntimeException("*******RunTimeException Occurred*******");
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Long id){
        return studentRepository.findById(id).orElseThrow(
                //invoke ResponseStatusException
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found" )
        );
    }
}
