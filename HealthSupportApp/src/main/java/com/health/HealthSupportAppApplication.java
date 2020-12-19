package com.health;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class HealthSupportAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthSupportAppApplication.class, args);
		System.out.println("Hello Spring boot");
	}

}
