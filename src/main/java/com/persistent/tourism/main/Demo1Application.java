package com.persistent.tourism.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.persistent.tourism.entities")
@EnableJpaRepositories("com.persistent.tourism.repos")
@ComponentScan(basePackages = {"com.persistent.tourism.controller", "com.persistent.tourism.services", "com.persistent.tourism.configuration"})
public class Demo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
	}

}
