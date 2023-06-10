package com.pragma.powerup.usermicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SquareMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SquareMicroserviceApplication.class, args);
	}

}
