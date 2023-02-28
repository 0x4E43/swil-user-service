package com.swil.userservice.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.swil.userservice.user.dto.UserDetailsDto;
import com.swil.userservice.user.service.UserDetailService;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    UserDetailService userDetailsService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveUser(@RequestBody UserDetailsDto user){
        return userDetailsService.saveUser(user);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String test(){
        return "userDetailsService.saveUser(user)";
    }

}
