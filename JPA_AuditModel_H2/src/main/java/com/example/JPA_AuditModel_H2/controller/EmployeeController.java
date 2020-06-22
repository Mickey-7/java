package com.example.JPA_AuditModel_H2.controller;

import com.example.JPA_AuditModel_H2.model.Employee;
import com.example.JPA_AuditModel_H2.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    private EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;

    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

    @GetMapping
    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id){
        employeeRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        Employee selectedEmployee = employeeRepository.findById(id).orElseThrow(null);
        selectedEmployee.setFirstName(employee.getFirstName());
        selectedEmployee.setLastName(employee.getLastName());
        return employeeRepository.save(selectedEmployee);

    }

}