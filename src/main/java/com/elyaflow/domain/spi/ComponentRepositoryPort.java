package com.elyaflow.domain.spi;


import com.elyaflow.domain.model.Component;
import io.smallrye.mutiny.Uni;

import java.util.List;
import java.util.UUID;

public interface ComponentRepositoryPort {
    Uni<Component> save(Component component);
    Uni<Component> findById(UUID id);
    Uni<List<Component>> findAll();
    Uni<Boolean> deleteById(UUID id);
}
