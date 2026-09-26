package com.first.genProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.first.genProject", "Service"})
public class GenProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(GenProjectApplication.class, args);
	}

}
