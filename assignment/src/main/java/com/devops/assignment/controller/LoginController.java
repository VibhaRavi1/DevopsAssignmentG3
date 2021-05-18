package com.devops.assignment.controller;

import com.devops.assignment.model.User;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1")
@CrossOrigin("http://localhost:4200")
public class LoginController {

    @GetMapping("/welcome")
    public String Init(){
        return "Welcome to Login page";
    }

    @GetMapping(path = "/user")
    public User getUser(){
        return new User("Rishav","Male","04/12/1998");
    }

}
