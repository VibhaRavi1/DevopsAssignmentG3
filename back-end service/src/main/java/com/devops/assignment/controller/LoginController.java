package com.devops.assignment.controller;

import com.devops.assignment.model.User;
import com.devops.assignment.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("http://localhost:4200")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/welcome")
    public String Init(){
        return "Welcome to Login page";
    }

    @GetMapping(path = "/user")
    public User getUser(){
        User user = loginService.getUserDetails();
        return user;
    }

}
