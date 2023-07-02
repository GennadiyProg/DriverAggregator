package com.example.driveraggregator.exceptions;

public class ViewMessageException extends RuntimeException{
    private final String message;

    public ViewMessageException(String message) {
        super();
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
