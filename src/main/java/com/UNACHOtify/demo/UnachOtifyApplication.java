package com.UNACHOtify.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.UNACHOtify.demo.repository")
public class UnachOtifyApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnachOtifyApplication.class, args);
	}

}
