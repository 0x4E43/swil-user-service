package com.swil.userservice.auth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String authController(){
        return "Auth Controller from User Service";
    }
    
}
