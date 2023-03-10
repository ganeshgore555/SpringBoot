package com.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloService {
	@GetMapping("/api/hello")
    public String hello(){
        return "Hello";
    }
}
