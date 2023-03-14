package com.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.*")
public class FastPassServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FastPassServiceApplication.class, args);
	}

}
