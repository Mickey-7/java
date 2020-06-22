package com.example.Java_Guides_Many_to_Many_H2.repository;

import com.example.Java_Guides_Many_to_Many_H2.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
