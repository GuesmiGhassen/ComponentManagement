package com.elyaflow.application.rest.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestDTO {

    @NotBlank(message = "Name is required")
    @Size(max = 20, message = "Name must be less than or equal to 20 characters")
    private String name;

}
