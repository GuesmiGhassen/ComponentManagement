package com.elyaflow.application;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class ApiResponse {
    private Object data;
    private int status;
    private String message;
    private LocalDateTime timestamp;
}
