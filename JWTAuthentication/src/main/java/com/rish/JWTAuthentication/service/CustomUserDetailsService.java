package com.rish.JWTAuthentication.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(username.equalsIgnoreCase("rishav")) {
            return new User("rishav","password123",new ArrayList<>());
        }
        if(username.equalsIgnoreCase("shalini")) {
            return new User("shalini","password1234",new ArrayList<>());
        }
        else {
            throw new UsernameNotFoundException("User not found.");
        }
    }
}
