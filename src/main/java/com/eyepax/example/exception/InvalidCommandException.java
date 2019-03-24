package com.eyepax.example.exception;

public class InvalidCommandException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InvalidCommandException(String errorMessage) {
        super(errorMessage);
    }

}
