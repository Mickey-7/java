package com.example.springboottransaction.service;

import com.example.springboottransaction.domain.Employee;
import com.example.springboottransaction.domain.EmployeeHealthInsurance;

public interface OrganizationService {
    void joinOrganization(Employee employee, EmployeeHealthInsurance employeeHealthInsurance);
    void leaveOrganization(Employee employee, EmployeeHealthInsurance employeeHealthInsurance);
}
