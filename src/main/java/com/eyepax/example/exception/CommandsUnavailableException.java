package com.eyepax.example.exception;

public class CommandsUnavailableException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public CommandsUnavailableException(String errorMessage) {
        super(errorMessage);
    }

}
