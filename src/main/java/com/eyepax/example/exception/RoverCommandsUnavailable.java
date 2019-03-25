package com.eyepax.example.exception;

public class RoverCommandsUnavailable extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public RoverCommandsUnavailable(String errorMessage) {
        super(errorMessage);
    }

}
