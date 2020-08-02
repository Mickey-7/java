package com.example.paginatingsortingh2v2.controller;

import com.example.paginatingsortingh2v2.domain.EmployeeEntity;
import com.example.paginatingsortingh2v2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    //NOTE: the url on Postman could be:
    //http://localhost:8080/employees?pageNo=2&pageSize=17&sortBy=email

    @GetMapping
    public ResponseEntity<List<EmployeeEntity>> getAllEmployees(
            @RequestParam Integer pageNo,
            @RequestParam Integer pageSize,
            @RequestParam String sortBy
    ){
        List<EmployeeEntity> list = service.getAllEmployees(pageNo, pageSize, sortBy);
        return new ResponseEntity<List<EmployeeEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }
}
