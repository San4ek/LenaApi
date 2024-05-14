package com.example.lenaapi.exceptions.user;

public class UserIsBlockedException extends Exception {
    public UserIsBlockedException() {
        this("User is blocked");
    }

    public UserIsBlockedException(String message) {
        super(message);
    }
}
