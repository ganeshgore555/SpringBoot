package com.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.client.WebClient;

import com.model.Customer;

@Controller
public class CustomerController {

    @Autowired
    private WebClient.Builder webClientBuilder;


    @RequestMapping(path="/customerdetails")
	public String getCustomerDetails(@RequestParam(defaultValue = "500") String customerId, Model m) {

        //WebClient client = WebClient.create();

        Customer customer = webClientBuilder.build().get()
            .uri("http://CUSTOMERSERVICE/customer?customerId=" + customerId)
            .retrieve()
            .bodyToMono(Customer.class)
            .block();
		
		System.out.println("customerId: " + customerId);
		m.addAttribute("customer", customer);
		return "console";

    }
    
}
