package com.elyaflow.domain.exceptions;

import jakarta.ws.rs.core.Response;

public class ResourceNotFoundException extends ExceptionHandler {
    public ResourceNotFoundException(String message) {
        super(Response.Status.NOT_FOUND, message);
    }
}
