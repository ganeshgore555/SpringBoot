package com.main;

import java.time.Instant;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.model.EmployeeBonus;

@SpringBootApplication
@ComponentScan(basePackages = "com.*")
public class EmployeeIntakeApplication/* implements CommandLineRunner*/ {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeIntakeApplication.class, args);
	}

	//@Bean
	public Consumer<EmployeeBonus> readEmployeeBonus() {
		return value -> {
			System.out.println("Received message for employee " + value.getEmployeeId() + " at " + Instant.now().toString());
		};
	}

	@Bean
	public Function<EmployeeBonus, EmployeeBonus> processEmployeeBonus() {
		return value -> { 
			System.out.println("Processing message with EmployeeId " + value.getEmployeeId());
			value.setDeptId("Fired");
			return value;
		};
	}

	//@Bean
	public Consumer<EmployeeBonus> readEmployeeGood() {
		return value -> {
			System.out.println("received message for (good) rated employee " + value.getEmployeeId() + " at " + Instant.now().toString());
		};
	}

	//@Bean
	public Consumer<EmployeeBonus> readEmployeeAverage() {
		return value -> {
			System.out.println("received message for (average) rated employee " + value.getEmployeeId() + " at " + Instant.now().toString());
		};
	}
/*
	@Override
	public void run(String... args) throws Exception {
		System.out.println("listening ...");

		//wait for input
		Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
		
	}
*/
}
