package com.elyaflow.domain.spi;


import com.elyaflow.domain.model.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ComponentRepositoryPort {
    void save(Component component);
    Optional<Component> findById(UUID id);
    List<Component> findAll();
    void deleteById(UUID id);
}
