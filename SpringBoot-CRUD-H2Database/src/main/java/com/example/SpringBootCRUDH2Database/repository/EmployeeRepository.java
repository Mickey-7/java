package com.example.SpringBootCRUDH2Database.repository;

import com.example.SpringBootCRUDH2Database.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
