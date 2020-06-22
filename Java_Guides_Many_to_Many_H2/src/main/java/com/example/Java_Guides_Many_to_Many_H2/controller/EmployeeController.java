package com.example.Java_Guides_Many_to_Many_H2.controller;

import com.example.Java_Guides_Many_to_Many_H2.model.Employee;
import com.example.Java_Guides_Many_to_Many_H2.model.Project;
import com.example.Java_Guides_Many_to_Many_H2.repository.EmployeeRepository;
import com.example.Java_Guides_Many_to_Many_H2.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    private EmployeeRepository employeeRepository;
    // for add project to employee
    private ProjectRepository projectRepository;
    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository, ProjectRepository projectRepository){
        this.employeeRepository = employeeRepository;
        this.projectRepository = projectRepository;
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

    //add project to employee
    @PostMapping("/{empId}/addProject/{projId}")
    public Employee addProjectToEmployee(@PathVariable Long empId, @PathVariable Long projId){
        // find the selected employee
        Employee selectedEmployee = employeeRepository.findById(empId).orElseThrow(null);
        // find the selected project
        Project selectedProject = projectRepository.findById(projId).orElseThrow(null);

        //add the selected project to selected employee
        //getProjects() -> output : List<Project>
        selectedEmployee.getProjects().add(selectedProject);

        // save the selected employee then return
        return employeeRepository.save(selectedEmployee);
    }
}
