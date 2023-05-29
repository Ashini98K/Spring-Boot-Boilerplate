package com.sample.boilerplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication ()
@EnableJpaRepositories
public class BoilerplateApplication {
	/**
	 * Main method that runs the application
	 */
	public static void main(String[] args) {
		SpringApplication.run(BoilerplateApplication.class, args);
	}

}
