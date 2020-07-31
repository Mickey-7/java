package com.example.swagger2documentation.controller;

import com.example.swagger2documentation.domain.Student;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class Swagger2DemoRestController {

    List<Student> students = new ArrayList<>();
    {
        students.add(new Student("Sajal", "IV", "India"));
        students.add(new Student("Lokesh", "V", "India"));
        students.add(new Student("Kajal", "III", "USA"));
        students.add(new Student("Sukesh", "VI", "USA"));
    }

    @RequestMapping("/getStudents")
    public List<Student> getStudents(){
        return students;
    }

    @RequestMapping("/getStudent/{name}")
    public Student getStudent(@PathVariable String name){
        return students.stream()
                .filter(x -> x.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList()).get(0);
    }

    @RequestMapping("/getStudentsByCountry/{country}")
    public List<Student> getStudentsByCountry(@PathVariable String country){
        System.out.println("Searching Student in country : " + country);
        List<Student> studentsByCountry = students.stream()
                .filter(x -> x.getCountry().equalsIgnoreCase(country))
                .collect(Collectors.toList());
        System.out.println(studentsByCountry);
        return studentsByCountry;
    }

    @RequestMapping("/getStudentByClass/{cls}")
    public List<Student> getStudentByClass(@PathVariable String cls){
        return students.stream()
                .filter(x -> x.getCls().equalsIgnoreCase(cls))
                .collect(Collectors.toList());
    }
}
