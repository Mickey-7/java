package com.example.DTOusingModelMapper.controller;

import com.example.DTOusingModelMapper.converter.StudentConverter;
import com.example.DTOusingModelMapper.domain.Student;
import com.example.DTOusingModelMapper.dto.StudentDto;
import com.example.DTOusingModelMapper.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    //invoke repository & converter
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    StudentConverter studentConverter;

    @GetMapping
    public List<StudentDto> findAll(){
        //use .findAll() on repository and set it to List<Student>
        List<Student> students = studentRepository.findAll();
        //use converter and invoke the students above
        return studentConverter.entityToDto(students);
    }

    @PostMapping
    public StudentDto save(@RequestBody StudentDto studentDto){
        //create Student and set it to converter
        Student student = studentConverter.dtoToEntity(studentDto);
        //use repository to save the student above
        student = studentRepository.save(student);
        //use converter and invoke the student above
        return studentConverter.entityToDto(student);
    }


    @GetMapping("/{id}")
    public StudentDto findById(@PathVariable Long id){
        //create Student and set it to repository with id
        Student student = studentRepository.findById(id).orElse(null);
        //use converter and invoke the student above
        return studentConverter.entityToDto(student);
    }

}
