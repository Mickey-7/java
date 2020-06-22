package com.example.Java_Guides_Many_to_Many_H2.controller;

import com.example.Java_Guides_Many_to_Many_H2.model.Employee;
import com.example.Java_Guides_Many_to_Many_H2.model.Project;
import com.example.Java_Guides_Many_to_Many_H2.repository.EmployeeRepository;
import com.example.Java_Guides_Many_to_Many_H2.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
    private ProjectRepository projectRepository;
    // for add employee to project
    private EmployeeRepository employeeRepository;
    @Autowired
    public ProjectController(ProjectRepository projectRepository, EmployeeRepository employeeRepository){
        this.projectRepository = projectRepository;
        this.employeeRepository = employeeRepository;
    }

    @PostMapping
    public Project addProject(@RequestBody Project project){
        return projectRepository.save(project);
    }

    @GetMapping
    public List<Project> getAllProject(){
        return projectRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable Long id){
        projectRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Project updateProject(@PathVariable Long id, @RequestBody Project project){
        Project selectedProject = projectRepository.findById(id).orElseThrow(null);
        selectedProject.setTitle(project.getTitle());
        return projectRepository.save(selectedProject);

    }

    //add Employee to Project
    @PostMapping("/{projId}/addEmployee/{empId}")
    public Employee addEmployeeToProject(@PathVariable Long projId, @PathVariable Long empId ){
        // find the selected employee
        Employee selectedEmployee = employeeRepository.findById(empId).orElseThrow(null);
        // find the selected project
        Project selectedProject = projectRepository.findById(projId).orElseThrow(null);

        //add the selected employee to selected project
        //getProjects() -> output : List<Project>
        selectedEmployee.getProjects().add(selectedProject);


        // save the selected employee then return
        return employeeRepository.save(selectedEmployee);
    }

}
