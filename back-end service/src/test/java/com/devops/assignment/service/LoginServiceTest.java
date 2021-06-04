package com.devops.assignment.service;

import com.devops.assignment.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(MockitoJUnitRunner.class)

public class LoginServiceTest {

    @Test
    public void getUserDetails(){
        LoginService loginService = new LoginService();
        User user = loginService.getUserDetails();
        User userTest = new User("Vibha","Female","04/12/1998");
        assertEquals(user.toString(),userTest.toString());
    }

}