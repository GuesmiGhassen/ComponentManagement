package com.elyaflow.domain.exceptions;

import com.elyaflow.application.ErrorResponse;
import jakarta.ws.rs.core.Response;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public abstract class ExceptionHandler extends RuntimeException {

    private final Response.Status status;
    private final String message;


    public ExceptionHandler(Response.Status status, String message) {
        super(message);
        this.status = status;
        this.message = message;
    }

    public Response handle() {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .status(status.getStatusCode())
                .message(message)
                .timestamp(LocalDateTime.now())
                .build();
        return Response.status(status).entity(errorResponse).build();
    }
}
