package com.emp.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EmpBaiscInfoAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpBaiscInfoAppApplication.class, args);
	}

}
