package com.example.springboottransaction.service;

import com.example.springboottransaction.domain.Employee;
import com.example.springboottransaction.repository.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public void insertEmployee(Employee employee) {
        employeeDao.insertEmployee(employee);
    }

    @Override
    public void deleteEmployeeById(String empId) {
        employeeDao.deleteEmployeeById(empId);
    }
}
