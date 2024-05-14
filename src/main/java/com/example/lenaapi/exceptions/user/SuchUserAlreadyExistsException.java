package com.example.lenaapi.exceptions.user;

public class SuchUserAlreadyExistsException extends Exception {
    public SuchUserAlreadyExistsException() {
        this("Such user already exists");
    }

    public SuchUserAlreadyExistsException(String message) {
        super(message);
    }
}
