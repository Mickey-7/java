package com.example.springboottransaction;

import com.example.springboottransaction.domain.Employee;
import com.example.springboottransaction.domain.EmployeeHealthInsurance;
import com.example.springboottransaction.service.OrganizationService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootTransactionApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(SpringBootTransactionApplication.class, args);
		OrganizationService organizationService = context.getBean(OrganizationService.class);
		Employee employee = new Employee();
		employee.setEmpId("emp1");
		employee.setEmpName("emp1");

		EmployeeHealthInsurance employeeHealthInsurance = new EmployeeHealthInsurance();
		employeeHealthInsurance.setEmpId("emp1");
		employeeHealthInsurance.setHealthInsuranceScheme("premium");
		employeeHealthInsurance.setCoverageAmount(20000);


		organizationService.joinOrganization(employee,employeeHealthInsurance);
	}

}
