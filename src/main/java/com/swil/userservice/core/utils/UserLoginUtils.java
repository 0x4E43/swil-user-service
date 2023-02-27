package com.swil.userservice.core.utils;

import java.util.UUID;
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
}
