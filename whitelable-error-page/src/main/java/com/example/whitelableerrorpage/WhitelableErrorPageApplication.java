package com.example.whitelableerrorpage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

@SpringBootApplication
public class WhitelableErrorPageApplication {

	public static void main(String[] args) {
		SpringApplication.run(WhitelableErrorPageApplication.class, args);
	}

}
