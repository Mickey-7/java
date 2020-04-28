package com.example.SimpleSchedulerSpringBootBatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
//the (exclude = DataSourceAutoConfiguration.class)
//will fix the Failed DataSource configuration
@EnableScheduling
//The @EnableScheduling annotation is used to enable the scheduler for your application.
// This annotation should be added into the main Spring Boot application class file.
public class SimpleSchedulerSpringBootBatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleSchedulerSpringBootBatchApplication.class, args);
	}

}
