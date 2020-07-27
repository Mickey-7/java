package com.example.ObjectMapperDemo.controller;

import com.example.ObjectMapperDemo.domain.Student;
import com.example.ObjectMapperDemo.domain.mixin.StudentIgnoreMixin;
import com.example.ObjectMapperDemo.repository.StudentRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/return_List<Student>")
    public List<Student> getAllStudent1(){
        List<Student> students = studentRepository.findAll();
        return students;
    }

    @GetMapping("/return_ResponseEntity<>")
    public ResponseEntity<?> getAllStudent2() throws JsonProcessingException {
        List<Student> students = studentRepository.findAll();

        //create ObjectMapper the use .addMixin()
        ObjectMapper mapper = new ObjectMapper();
        //.addMixin(Class <?> target , Class<?> mixinSource) -> output : ObjectMapper
        //invoke Student & StudentIgnoreMixin class
        mapper.addMixIn(Student.class, StudentIgnoreMixin.class);

        //.writeValueAsString(Object value) -> output : String
        //invoke students from above and also the mapper
        String jsonString = mapper.writeValueAsString(students);
        //underline will appear on writeValueAsString,
        //just throw exception and throw JsonProcessingException will be added on this method

        //.ok(T body) -> output : ResponseEntity<T>
        //.contentType(MediaType mediaType) -> output : BodyBuilder
        //.body(T t) -> output : ResponseEntity<T>
        //invoke the jsonString from above
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(jsonString);


    }

    @PostMapping
    public Student saveStudent(@RequestBody Student student){
        return  studentRepository.save(student);
    }


}
