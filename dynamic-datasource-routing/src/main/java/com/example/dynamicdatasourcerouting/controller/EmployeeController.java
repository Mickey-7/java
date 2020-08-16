package com.example.dynamicdatasourcerouting.controller;

import com.example.dynamicdatasourcerouting.domain.Employee;
import com.example.dynamicdatasourcerouting.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee")
    public ResponseEntity<List<Employee>> getEmployees(){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(employeeService.getEmployees());
    }
}
