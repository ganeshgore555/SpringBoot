package com.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdditionService {
	
	@GetMapping("/api/add")
    public Integer add(@RequestParam Integer num1, @RequestParam Integer num2){
        return Integer.sum(num1,num2);
    }
}
