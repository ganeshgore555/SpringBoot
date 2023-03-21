package com.main;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.model.Employee;

import reactor.core.publisher.Flux;

@SpringBootApplication
public class SpringWebFunctionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebFunctionApplication.class, args);
	}

	List<Employee> employeeList;

	public SpringWebFunctionApplication() {
		employeeList = new ArrayList<Employee>();
		employeeList.add(new Employee(1, "Rob", 30));
		employeeList.add(new Employee(2, "Jim", 25));
		employeeList.add(new Employee(3, "Jack", 56));
		employeeList.add(new Employee(4, "Mark", 34));
		employeeList.add(new Employee(5, "Mike", 65));
	}
	
	@Bean
	public Function<Integer,Employee> findEmployee(){
		return id -> {
			return employeeList.stream().filter(emp -> emp.getId() == id ).findAny().orElse(null);
		};
	}
	
	@Bean
	public Supplier<Flux<Employee>> allEmployee(){
		return () -> {
			return Flux.fromIterable(employeeList);
		};
	}
	
	@Bean
	public Consumer<Flux<Employee>> addEmployee(){
		return value -> {
			 value.subscribe(employee -> System.out.println(employee));
		};
	}
	
}
