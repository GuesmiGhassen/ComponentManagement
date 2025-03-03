package com.elyaflow.domain.service;

import com.elyaflow.domain.exceptions.ResourceNotFoundException;
import com.elyaflow.domain.model.Component;
import com.elyaflow.domain.spi.ComponentRepositoryPort;
import io.quarkus.hibernate.reactive.panache.common.WithTransaction;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
@RequiredArgsConstructor
public class ComponentService {


    private final ComponentRepositoryPort componentRepository;

    public Uni<Component> createComponent(String name) {
        Component component = new Component(name);
        return componentRepository.save(component);
    }

    public Uni<List<Component>> getAllComponents() {
        return componentRepository.findAll();
    }

    public Uni<Component> findComponentById(UUID id) {
        return componentRepository.findById(id);
    }

    @WithTransaction
    public Uni<Component> updateComponent(UUID id, String name) {
        return componentRepository.findById(id)
                .onItem().ifNull().failWith(() -> new ResourceNotFoundException("Component with id: " + id + " not found"))
                .invoke(component -> component.setName(name));
    }

    public Uni<Boolean> deleteComponent(UUID id) {
        return componentRepository.findById(id)
                .onItem().ifNull().failWith(() -> new ResourceNotFoundException("Component with id: " + id + " not found"))
                .flatMap(component -> componentRepository.deleteById(component.getId()));
    }
}
