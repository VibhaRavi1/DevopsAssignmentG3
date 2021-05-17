package com.rish.JWTAuthentication.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class HomeController {

    @GetMapping("/welcome")
    public String welcome() {
        return "This is a private page. Unauthorized people are not welcome";
    }
}
