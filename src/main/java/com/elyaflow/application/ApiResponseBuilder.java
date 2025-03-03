package com.elyaflow.application;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;

import java.time.LocalDateTime;

@ApplicationScoped
public class ApiResponseBuilder {
    public <T> Response buildSuccessResponse(T data) {
        return Response.ok(
                ApiResponse.builder()
                        .status(Response.Status.OK.getStatusCode())
                        .message("Success")
                        .data(data)
                        .timestamp(LocalDateTime.now())
                        .build()
        ).build();
    }

    public Response buildErrorResponse(Throwable throwable, String errorMessage) {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(ApiResponse.builder()
                        .status(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode())
                        .message(errorMessage + ": " + throwable.getMessage())
                        .timestamp(LocalDateTime.now())
                        .build()
                ).build();
    }
}
