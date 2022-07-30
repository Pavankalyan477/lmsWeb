package com.example.lms_Clone.Exception;

public class UserNotFound extends  RuntimeException{
    public UserNotFound(String message) {
        super(message);
    }
}
