package com.example.cascadeonetomany;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.cascadeonetomany.*")
@EntityScan("com.example.cascadeonetomany.*")
public class CascadeOneToManyApplication {

	public static void main(String[] args) {
		SpringApplication.run(CascadeOneToManyApplication.class, args);
	}

}
