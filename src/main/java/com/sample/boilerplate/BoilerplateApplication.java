package com.sample.boilerplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


//Main class
@SpringBootApplication ()
@EnableJpaRepositories
//@EnableSwagger2
//@ComponentScan("com.sample.boilerplate.configs") // Replace with the correct package name
public class BoilerplateApplication {
	/**
	 * Main class that runs the application
	 */
	public static void main(String[] args) {
		SpringApplication.run(BoilerplateApplication.class, args);
	}

//	@Bean
//	public Docket productApi() {
//		return new Docket(DocumentationType.SWAGGER_2).select()
//				.apis(RequestHandlerSelectors.basePackage("com.sample.boilerplate.controllers")).build();
//	}
}
