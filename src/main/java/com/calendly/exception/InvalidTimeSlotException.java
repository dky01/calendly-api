package com.calendly.exception;

public class InvalidTimeSlotException extends CalendlyException {

    public InvalidTimeSlotException(String message) {
        super(message);
    }

    @Override
    public int getCode() {
        return 400;
    }
}
