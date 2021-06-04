package com.devops.assignment.service;

import com.devops.assignment.model.User;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public User getUserDetails(){
        return new User("Vibha","Female","04/12/1998");
    }
}
