package com.elyaflow.infrastructure;

import com.elyaflow.domain.model.Component;
import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.UUID;

@ApplicationScoped
public class ComponentRepository implements PanacheRepositoryBase<Component, UUID> {
}
