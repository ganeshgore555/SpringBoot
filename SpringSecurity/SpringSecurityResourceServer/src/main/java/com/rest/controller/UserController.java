package com.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.User;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    private List<User> userList;

    public UserController() {

    	userList = new ArrayList<User>();
    	userList.add(new User("Ganesh",35,"India"));
    	userList.add(new User("Mark",58,"US"));
    	userList.add(new User("Pablo",45,"Columbia"));
    }

    @RequestMapping("/api/getUserData")
    public List<User> getUserData() {
        return userList;
    }
    
}
