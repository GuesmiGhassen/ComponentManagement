package com.elyaflow.application.api;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter

public class ComponentDTO {

    private UUID id;
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String modifiedBy;

    public ComponentDTO(UUID id, String name, LocalDateTime createdAt, LocalDateTime updatedAt, String modifiedBy) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.modifiedBy = modifiedBy;
    }
}
