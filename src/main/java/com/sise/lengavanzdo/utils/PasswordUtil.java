package com.sise.lengavanzdo.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.SecureRandom;

public class PasswordUtil {
    /*public PasswordEncoder encode(){
        return new BCryptPasswordEncoder();
    }*/
    public static String encode(String text){
        int strength = 10; // work factor of bcrypt
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(strength, new SecureRandom());
        String encodedPassword = bCryptPasswordEncoder.encode(text);
        return  encodedPassword;
    }
}
