package com.example.ObjectMapperDemo.startup;

import com.example.ObjectMapperDemo.domain.Student;
import com.example.ObjectMapperDemo.repository.StudentRepository;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Log
public class StartupUtility implements CommandLineRunner {
    @Value("${demo.json.string}")
    private String json;
    @Autowired
    private StudentRepository studentRepository;

    //underline will appear on above class name when implemented CommandLineRunner,
    //just ALT + Enter on i, then select implement override method
    @Override
    public void run(String... args) throws Exception {
        //instantiate blank ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        //.configure(Feature f, Boolean b) -> output : ObjectMapper
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        //invoke  json from above & the Student class
        //the json above is a dummy data which is defined on application.properties
        Student student = mapper.readValue(json, Student.class);
        //invoke repository
        Student savedStudent = studentRepository.save(student);

        //notice how we use log directly-- this is due to lombok
        log.info("Student info "+savedStudent.toString());
    }
}
