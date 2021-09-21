package com.example.demosetupproject.exceptions;

public class UserNameNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public String UsernameNotFoundException(String username) {
        return ("Cannot find user " + username);
    }
}
