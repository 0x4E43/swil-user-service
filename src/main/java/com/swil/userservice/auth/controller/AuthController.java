package com.swil.userservice.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.swil.userservice.auth.dto.UserAuthDto;
import com.swil.userservice.auth.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {


    @Autowired
    AuthService authService;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String authControllerTest(){
        return "Auth Controller from User Service";
    }

    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String authController(@RequestBody UserAuthDto dto){
        return authService.login(dto);
    }
    
}
