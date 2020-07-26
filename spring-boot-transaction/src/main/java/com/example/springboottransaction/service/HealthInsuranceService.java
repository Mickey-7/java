package com.example.springboottransaction.service;

import com.example.springboottransaction.domain.EmployeeHealthInsurance;

public interface HealthInsuranceService {
    void registerEmployeeHealthInsurance(EmployeeHealthInsurance employeeHealthInsurance);
    void deleteEmployeeHealthInsuranceById(String empId);
}
