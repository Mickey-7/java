package com.example.springboottransaction.repository;

import com.example.springboottransaction.domain.Employee;

public interface EmployeeDao {
    void insertEmployee(Employee employee);
    void deleteEmployeeById(String empId);
}
