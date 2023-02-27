package com.swil.userservice.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.swil.userservice.user.dto.UserDetailsDto;
import com.swil.userservice.user.service.UserDetailsService;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    UserDetailsService userDetailsService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveUser(@RequestBody UserDetailsDto user){
        return userDetailsService.saveUser(user);
    }

}
