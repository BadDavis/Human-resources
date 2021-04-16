package com.hr.manager.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String s) {
        super(s);
    }
}
