package com.example.DTOusingModelMapper.repository;

import com.example.DTOusingModelMapper.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
}
