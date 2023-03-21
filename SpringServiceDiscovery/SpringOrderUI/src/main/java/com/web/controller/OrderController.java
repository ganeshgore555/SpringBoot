package com.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.client.WebClient;

import com.model.Order;

@Controller
public class OrderController {

    @Autowired
    private WebClient.Builder webClientBuilder;

    @RequestMapping("/order")
	public String GetTollRate(@RequestParam(defaultValue = "1000") Integer orderId, Model m) {

        //WebClient client = WebClient.create();

        Order order = webClientBuilder.build().get()
            .uri("http://ORDERSERVICE/orderById/" + orderId)
            .retrieve()
            .bodyToMono(Order.class)
            .block();
		
		System.out.println("orderId: " + orderId);
		m.addAttribute("order", order);
		return "dashboard";
	}   
}
