package com.example.Java_Guides_Many_to_Many_H2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class JavaGuidesManyToManyH2Application {

	public static void main(String[] args) {
		SpringApplication.run(JavaGuidesManyToManyH2Application.class, args);
	}

}
