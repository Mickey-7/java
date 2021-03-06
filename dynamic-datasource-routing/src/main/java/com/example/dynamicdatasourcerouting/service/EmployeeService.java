package com.example.dynamicdatasourcerouting.service;

import com.example.dynamicdatasourcerouting.domain.Employee;
import com.example.dynamicdatasourcerouting.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }
}
