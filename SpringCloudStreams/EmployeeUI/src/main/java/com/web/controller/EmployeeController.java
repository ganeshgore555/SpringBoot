package com.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.client.WebClient;

import com.model.Employee;
import com.model.EmployeeBonus;

@Controller
public class EmployeeController {

    @Autowired
	StreamBridge streamBridge;


    @RequestMapping(path="/employeeDetails")
	public String getFastPassCustomerDetails(@RequestParam(defaultValue = "800") String employeeId, Model m) {

        WebClient client = WebClient.create();

        Employee employee = client.get()
            .uri("http://localhost:8085/employee?employeeId=" + employeeId)
            .retrieve()
            .bodyToMono(Employee.class)
            .block();
		
		System.out.println("employeeId: " + employeeId);
		m.addAttribute("employee", employee);
		
        //send message to stream endpoint first
        streamBridge.send("generatebonus-out-0", new EmployeeBonus(employeeId, "1000", 9999));

        //return view name
		return "console";

    }
    
}
