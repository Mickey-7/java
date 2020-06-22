package com.example.JPA_AuditModel_H2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


// Enabling JPA Auditing
@EnableJpaAuditing
@SpringBootApplication
public class JpaAuditModelH2Application {

	public static void main(String[] args) {
		SpringApplication.run(JpaAuditModelH2Application.class, args);
	}

}
