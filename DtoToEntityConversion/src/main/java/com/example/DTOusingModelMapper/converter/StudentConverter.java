package com.example.DTOusingModelMapper.converter;

import com.example.DTOusingModelMapper.domain.Student;
import com.example.DTOusingModelMapper.dto.StudentDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentConverter {

    //Student to StudentDto
    public StudentDto entityToDto(Student student){
        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setName(student.getName());
        studentDto.setUsername(student.getUsername());
        studentDto.setPassword(student.getPassword());


        return studentDto;
    }

    public List<StudentDto> entityToDto(List<Student> students){
        //invoking the above entityToDto(Student student) method
        return students.stream().map( x -> entityToDto(x)).collect(Collectors.toList());
    }


    //StudentDto to Student
    public Student dtoToEntity(StudentDto studentDto){
        Student student = new Student();
        student.setId(studentDto.getId());
        student.setName(studentDto.getName());
        student.setUsername(studentDto.getUsername());
        student.setPassword(studentDto.getPassword());

        return student;
    }

    public List<Student> dtoToEntity(List<StudentDto> studentDtos){
        //invoking the above dtoToEntity(List<StudentDto> studentDtos) method
        return studentDtos.stream().map( x -> dtoToEntity(x)).collect(Collectors.toList());
    }


}
