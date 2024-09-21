package com.calendly.exception;

public class UserNotFoundException extends CalendlyException {

    public UserNotFoundException(String userId) {
        super("User with id " + userId + " not found");
    }

    @Override
    public int getCode() {
        return 404;
    }
}
