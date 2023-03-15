package com.rest.controller;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Order;

@RestController
public class OrderController {

    List<Order> orders;

    public OrderController() {
    	orders = new ArrayList<Order>();
    	orders.add(new Order(1000, 500, 465.55f, Instant.now().toString()));
    	orders.add(new Order(1001, 501, 232.05f, Instant.now().toString()));
    	orders.add(new Order(1002, 501, 872.60f, Instant.now().toString()));
    	orders.add(new Order(1003, 502, 223.00f, Instant.now().toString()));
    }

    @RequestMapping("/orderById/{orderId}")
    public Order GetTollRate(@PathVariable int orderId) {
        System.out.println("Order requested: " + orderId);
        return orders.stream().filter(order -> orderId == order.getOrderId()).findAny().orElse(new Order());
    }
    
}
