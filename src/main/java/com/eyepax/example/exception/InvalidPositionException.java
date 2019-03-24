package com.eyepax.example.exception;

public class InvalidPositionException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InvalidPositionException(String errorMessage) {
        super(errorMessage);
    }

}
