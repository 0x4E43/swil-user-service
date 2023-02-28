package com.swil.userservice.auth.service;

import org.springframework.stereotype.Service;

import com.swil.userservice.auth.dto.UserAuthDto;
import com.swil.userservice.core.dto.Response;

@Service
public class AuthService {
    public String login(UserAuthDto dto){
        return Response.success("Login Successfull", dto);
    }
}
