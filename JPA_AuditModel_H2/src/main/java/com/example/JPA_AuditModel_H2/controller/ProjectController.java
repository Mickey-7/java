package com.example.JPA_AuditModel_H2.controller;

import com.example.JPA_AuditModel_H2.model.Project;
import com.example.JPA_AuditModel_H2.repository.EmployeeRepository;
import com.example.JPA_AuditModel_H2.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
    private ProjectRepository projectRepository;
    @Autowired
    public ProjectController(ProjectRepository projectRepository){
        this.projectRepository = projectRepository;

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
}
