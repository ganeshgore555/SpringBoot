package com.rest.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.model.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "*")
public class UserController {
   
    @Autowired
	private WebClient webClient;
	
    @RequestMapping("/")
	public String loadHome() {
        return "home";
    }

    @RequestMapping("/user")
	public Mono<User> loadUser(){		
		Flux<User> response = this.webClient.get()
		        .uri("http://localhost:8081/api/getUserData")
		        .retrieve()
		        .bodyToFlux(User.class);
		        List<User> userdata = response.collectList().block();
		        return Mono.just(userdata.get(0));
	}
    
}
