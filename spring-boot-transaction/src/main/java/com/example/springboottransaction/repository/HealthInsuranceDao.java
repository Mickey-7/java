package com.example.springboottransaction.repository;

import com.example.springboottransaction.domain.EmployeeHealthInsurance;

public interface HealthInsuranceDao {
    void registerEmployeeHealthInsurance(EmployeeHealthInsurance employeeHealthInsurance);
    void deleteEmployeeHealthInsuranceById(String empId);
}
