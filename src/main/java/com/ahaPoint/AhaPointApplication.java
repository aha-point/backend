package com.ahaPoint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.ahaPoint")
public class AhaPointApplication {

	public static void main(String[] args) {
		SpringApplication.run(AhaPointApplication.class, args);
	}

}
