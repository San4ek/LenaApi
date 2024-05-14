package com.example.lenaapi.exceptions.user;

public class NoSuchUserException extends Exception {
    public NoSuchUserException() {
        this("No such user");
    }

    public NoSuchUserException(String message) {
        super(message);
    }
}