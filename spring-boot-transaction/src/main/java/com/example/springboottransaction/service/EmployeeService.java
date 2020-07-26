package com.example.springboottransaction.service;

import com.example.springboottransaction.domain.Employee;

public interface EmployeeService {
    void insertEmployee(Employee employee);
    void deleteEmployeeById(String empId);
}
