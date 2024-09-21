package com.calendly;

import com.calendly.exception.CalendlyException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;

public class CalendlyExceptionMapper implements ExceptionMapper<CalendlyException> {

    static class ErrorResponse {
        public int code;
        public String message;
        public ErrorResponse() {};

        public ErrorResponse(int code, String message) {
            this.code = code;
            this.message = message;
        }
    }

    @Override
    public Response toResponse(CalendlyException exception) {
        return Response
                .status(Response.Status.BAD_REQUEST)
                .entity(new ErrorResponse(exception.getCode(), exception.getMessage()))
                .build();
    }
}
