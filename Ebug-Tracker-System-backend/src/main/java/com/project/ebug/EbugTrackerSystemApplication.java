package com.project.ebug;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class EbugTrackerSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(EbugTrackerSystemApplication.class, args);
	}

}
