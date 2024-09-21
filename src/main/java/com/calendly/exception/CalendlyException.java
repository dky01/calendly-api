package com.calendly.exception;

public abstract class CalendlyException extends RuntimeException {

    public CalendlyException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "CalendlyException: " + super.getMessage();
    }

    public abstract int getCode();

}
