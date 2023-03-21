package com.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.model.Employee;

@RestController
public class EmployeeController {

    List<Employee> employeeList;

    public EmployeeController() {

    	employeeList = new ArrayList<Employee>();
    	employeeList.add(new Employee("800", "Tom", "555-123-4567", 194543));
    	employeeList.add(new Employee("801", "Dick", "555-321-7654", 234423));
    	employeeList.add(new Employee("802", "Harry", "555-987-6543", 632354));

    }
    
    @RequestMapping(path="/employee", params={"employeeId"})
    public Employee getFastPassById(@RequestParam String employeeId) {
        System.out.println("Employee retrieved for " + employeeId);
        return employeeList.stream().filter(employee -> employeeId.equals(employee.getEmployeeId())).findAny().orElse(new Employee());
    }
}
