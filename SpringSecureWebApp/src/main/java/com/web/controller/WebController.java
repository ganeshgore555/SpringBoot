package com.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.function.client.WebClient;

import com.model.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class WebController {
	
    @Autowired
	private WebClient webClient;
	
    @RequestMapping("/")
	public String loadHome() {
        return "home";
    }

    @RequestMapping("/report")
	public String loadReport(Model m){
        //call downstream service
		Flux<User> response = this.webClient.get()
        .uri("http://localhost:8081/api/getUserData")
        .retrieve()
        .bodyToFlux(User.class);
        List<User> userList = response.collectList().block();
        m.addAttribute("userList", userList);
		return "report";
	}
    
}
