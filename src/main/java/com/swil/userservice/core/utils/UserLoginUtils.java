package com.swil.userservice.core.utils;

import java.util.UUID;

import com.swil.userservice.user.dto.UserInfoDto;
public class UserLoginUtils {

    public static String generateUuid() {
        try{
            UUID uuid = UUID.randomUUID();
            return uuid.toString();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static String hashPassword( String plainPassword) {
        return null;
    }

    //This method generate JWT
    public static String generateJWT(UserInfoDto dto) {
        return null;
    }
}
