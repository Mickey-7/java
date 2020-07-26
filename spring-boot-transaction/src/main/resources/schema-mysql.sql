DROP TABLE if EXISTS employee;
DROP TABLE if EXISTS employeeHealthInsurance;

CREATE TABLE employee(
    empId varchar(10) not null,
    empName varchar(100) not null
);

CREATE TABLE employeeHealthInsurance(
    empId varchar(10) not null,
    healthInsuranceSchemeName varchar(100) not null,
    coverageAmount varchar(100) not null
);

