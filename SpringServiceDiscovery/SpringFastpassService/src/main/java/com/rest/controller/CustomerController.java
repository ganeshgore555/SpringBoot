package com.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.model.Customer;

@RestController
public class CustomerController {

    List<Customer> customers;

    public CustomerController() {

        customers = new ArrayList<Customer>();
        customers.add(new Customer("500", "Ganesh", "345-854-1234", 345.23f));
        customers.add(new Customer("501", "Mike", "755-332-8376", 688.75f));
        customers.add(new Customer("502", "Lee", "865-853-0982", 22.00f));

    }
    
    @RequestMapping(path="/customer", params={"customerId"})
    public Customer getCustomerById(@RequestParam String customerId) {
        System.out.println("Customer retrieved for " + customerId);
        return customers.stream().filter(customer -> customerId.equals(customer.getCustomerId())).findAny().orElse(new Customer());
    }
}
