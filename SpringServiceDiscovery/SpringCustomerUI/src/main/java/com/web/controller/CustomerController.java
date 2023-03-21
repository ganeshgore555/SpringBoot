package com.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.ReactiveCircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.ReactiveCircuitBreakerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.client.WebClient;

import com.model.Customer;

import reactor.core.publisher.Mono;

@Controller
public class CustomerController {

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Autowired
    private ReactiveCircuitBreakerFactory circuitBreakerFactory;

    @RequestMapping(path="/customerdetails")
	public String getCustomerDetails(@RequestParam(defaultValue = "500") String customerId, Model m) {

        //WebClient client = WebClient.create();

    	ReactiveCircuitBreaker reactiveCircuitBreaker = circuitBreakerFactory.create("customerCircuitBreaker");
    	
    	Mono<Customer> customer = reactiveCircuitBreaker.run(webClientBuilder.build().get()
            .uri("http://CUSTOMERSERVICE/customerSlow?customerId=" + customerId)
            .retrieve()
            .bodyToMono(Customer.class),
            throwable -> getDefaultCustomer());
		
		System.out.println("customerId: " + customerId);
		m.addAttribute("customer", customer.block());
		return "console";

    }
    
    private Mono<Customer> getDefaultCustomer(){
    	System.out.println("Fallback triggered");
    	return Mono.just(new Customer("007", "Something is fishy!", "102-372-1108", 4.64f));
    }
    
}
