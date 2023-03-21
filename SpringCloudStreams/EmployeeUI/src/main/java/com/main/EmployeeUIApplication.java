package com.main;

import java.util.ArrayList;
import java.util.function.Supplier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

import com.model.EmployeeBonus;

import reactor.core.publisher.Flux;


@SpringBootApplication
@ComponentScan(basePackages = "com.*")
public class EmployeeUIApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeUIApplication.class, args);
	}

	//@Bean
	public Supplier<EmployeeBonus> generateBonus() {
		return () -> new EmployeeBonus("800", "1001", 123);
	}

	//@Bean
	public Supplier<Flux<Message<EmployeeBonus>>> generateThreeBonuses() {

		ArrayList<Message<EmployeeBonus>> employees = new ArrayList<Message<EmployeeBonus>>();
		employees.add(MessageBuilder
			.withPayload(new EmployeeBonus("800", "1001", 83474))
			.setHeader("rating", "good")
			.build());
		employees.add(MessageBuilder
			.withPayload(new EmployeeBonus("801", "1001", 56233))
			.setHeader("rating", "average")
			.build());
		employees.add(MessageBuilder
			.withPayload(new EmployeeBonus("802", "1001", 45232))
			.setHeader("rating", "good")
			.build());

			return() -> Flux.fromIterable(employees);
	}

}
