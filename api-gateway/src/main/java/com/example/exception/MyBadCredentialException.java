package com.example.exception;

public class MyBadCredentialException extends RuntimeException {
    private final String message;

    public MyBadCredentialException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage(){
        return message;
    }
}
