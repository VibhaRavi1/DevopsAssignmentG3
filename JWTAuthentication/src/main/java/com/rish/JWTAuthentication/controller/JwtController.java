package com.rish.JWTAuthentication.controller;

import com.rish.JWTAuthentication.model.JwtRequest;
import com.rish.JWTAuthentication.model.JwtResponse;
import com.rish.JWTAuthentication.service.CustomUserDetailsService;
import com.rish.JWTAuthentication.utility.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authenticate")
@CrossOrigin(origins = "*")
public class JwtController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtUtil jwtUtil;


    @PostMapping("/token")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) {
        System.out.println(jwtRequest);
        try {
            this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(),jwtRequest.getPassword()));
        }
        catch (UsernameNotFoundException ue) {
            ue.printStackTrace();
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("No User found.");
        }
        catch (BadCredentialsException badCredentialsException) {
            badCredentialsException.printStackTrace();
            ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Bad Credentials");
        }
        catch (Exception e) {
            e.printStackTrace();
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong. Try again");
        }

        UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(jwtRequest.getUsername());

        String token = this.jwtUtil.generateToken(userDetails);
        System.out.println("JWT -->>" + token);

        return ResponseEntity.ok(new JwtResponse(token));
    }
}
