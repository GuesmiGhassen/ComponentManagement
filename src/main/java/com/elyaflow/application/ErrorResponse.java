package com.elyaflow.application;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class ErrorResponse {
    private final String message;
    private final int status;
    private final LocalDateTime timestamp;
}