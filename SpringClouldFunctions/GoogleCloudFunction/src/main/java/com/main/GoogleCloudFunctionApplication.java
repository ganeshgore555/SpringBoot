package com.main;

import java.util.function.Function;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

//entry point for JAR org.springframework.cloud.function.adapter.gcp.GcfJarLauncher

@SpringBootApplication
public class GoogleCloudFunctionApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoogleCloudFunctionApplication.class, args);
	}

	@Bean
	public Function<String, String> greet() {
		return value -> "Welcome, Google cloud user " + value;
	}

}
