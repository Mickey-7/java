package com.example.springboottransaction.domain;

public class EmployeeHealthInsurance {
    private String empId;
    private String healthInsuranceScheme;
    private int coverageAmount;

    public EmployeeHealthInsurance() {
    }

    public EmployeeHealthInsurance(String empId, String healthInsuranceScheme, int coverageAmount) {
        this.empId = empId;
        this.healthInsuranceScheme = healthInsuranceScheme;
        this.coverageAmount = coverageAmount;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getHealthInsuranceScheme() {
        return healthInsuranceScheme;
    }

    public void setHealthInsuranceScheme(String healthInsuranceScheme) {
        this.healthInsuranceScheme = healthInsuranceScheme;
    }

    public int getCoverageAmount() {
        return coverageAmount;
    }

    public void setCoverageAmount(int coverageAmount) {
        this.coverageAmount = coverageAmount;
    }

    @Override
    public String toString() {
        return "EmployeeHealthInsurance{" +
                "empId='" + empId + '\'' +
                ", healthInsuranceScheme='" + healthInsuranceScheme + '\'' +
                ", coverageAmount=" + coverageAmount +
                '}';
    }
}
