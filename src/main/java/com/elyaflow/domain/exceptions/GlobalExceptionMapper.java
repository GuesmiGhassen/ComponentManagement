package com.elyaflow.domain.exceptions;

import com.elyaflow.application.ErrorResponse;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.time.LocalDateTime;

@Provider
public class GlobalExceptionMapper implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception exception) {
        if (exception instanceof ExceptionHandler) {
            return ((ExceptionHandler) exception).handle();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(ErrorResponse.builder()
                            .status(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode())
                            .message("An unexpected error occurred")
                            .timestamp(LocalDateTime.now())
                            .build())
                    .build();
        }
    }
}
