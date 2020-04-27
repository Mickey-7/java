package com.example.SpringBootCRUDH2Database.controller;

import com.example.SpringBootCRUDH2Database.advice.ResourceNotFoundException;
import com.example.SpringBootCRUDH2Database.domain.Employee;
import com.example.SpringBootCRUDH2Database.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    private EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

    @DeleteMapping("/employees/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable Long id) throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(id)
                //invoke specific exception
                //.orElseThrow(Supplier<? extends X>exceptionSupplier) -> output : Employee
                //add exception on .orElseThrow
                .orElseThrow(() -> new ResourceNotFoundException("Employee with "+id+" not found"));
        employeeRepository.delete(employee);
        //create blank response Map
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted",Boolean.TRUE);
        return response;
    }

    @GetMapping("/employees/{id}")
    //ResponseEntity with Employee input data type
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee with "+id+" not found"));
        //.ok(T body) -> output : ResponseEntity<T>
        //.body(T t) -> output : ResponseEntity<T>
        return ResponseEntity.ok().body(employee);
        //ResponseEntity with employee embedded on body
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) throws ResourceNotFoundException {
        Employee employeeSelected = employeeRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Employee with "+id+" not found"));
        //set attributes of employeeSelected to employee from input param
        employeeSelected.setEmailId(employee.getEmailId());
        employeeSelected.setFirstName(employee.getFirstName());
        employeeSelected.setLastName(employee.getLastName());
        //create blank updatedEmployee then save the employeeSelected to repository
        Employee updatedEmployee = employeeRepository.save(employeeSelected);
        //return ResponseEntity with updatedEmployee embedded on body
        return ResponseEntity.ok().body(updatedEmployee);
    }
}
