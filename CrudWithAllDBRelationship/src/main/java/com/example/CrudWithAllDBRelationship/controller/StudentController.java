package com.example.CrudWithAllDBRelationship.controller;

import com.example.CrudWithAllDBRelationship.domain.Student;
import com.example.CrudWithAllDBRelationship.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @PostMapping
    public Student save(@RequestBody Student student){
        return studentRepository.save(student);
    }

    @GetMapping
    public List<Student> findAllStudent(){
        return studentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Student find(@PathVariable Long id){
        Student student = studentRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Student is not present on database")
        );
        return student;
    }

    @PutMapping
    public Student update(@RequestBody Student  student){
        return studentRepository.save(student);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        Student student = studentRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Student is not present on database")
        );
        studentRepository.delete(student);
        return "Student deleted Successfully ...!";

    }

}
