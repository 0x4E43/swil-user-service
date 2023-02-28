package com.swil.userservice.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.swil.userservice.user.dto.UserInfoDto;
import com.swil.userservice.user.service.UserInfoService;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    UserInfoService userDetailsService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveUser(@RequestBody UserInfoDto user){
        return userDetailsService.saveUser(user);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String test(){
        return "userDetailsService.saveUser(user)";
    }

}
