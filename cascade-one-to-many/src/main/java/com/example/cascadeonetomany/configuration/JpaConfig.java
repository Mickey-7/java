package com.example.cascadeonetomany.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.example.cascadeonetomany.repository")
public class JpaConfig {
}
