package com.elyaflow.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "components")
public class Component {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false, updatable = false)
    @JsonProperty("id")
    private UUID id;

    @Column(nullable = false)
    @Setter
    @JsonProperty("name")
    private String name;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    @JsonProperty("createdAt")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(nullable = false)
    @JsonProperty("updatedAt")
    private LocalDateTime updatedAt;

    @JsonProperty("modifiedBy")
    private String modifiedBy;

    public Component(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Component [id=" + id + ", name=" + name + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", modifiedBy=" + modifiedBy + "]";
    }

}
