package com.elyaflow.infrastructure.gateway.database;

import com.elyaflow.domain.model.Component;
import com.elyaflow.domain.spi.ComponentRepositoryPort;
import com.elyaflow.infrastructure.ComponentRepository;
import io.quarkus.hibernate.reactive.panache.Panache;
import io.quarkus.hibernate.reactive.panache.common.WithTransaction;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
@RequiredArgsConstructor
public class ComponentRepositoryAdapter implements ComponentRepositoryPort {

    private final ComponentRepository componentRepository;

    @Override
    @WithTransaction
    public Uni<Component> save(Component component) {
        return componentRepository.persist(component);
    }

    @Override
    public Uni<Component> findById(UUID id) {
        return Panache.withSession(() -> componentRepository.findById(id)) ;
    }

    @Override
    public Uni<List<Component>> findAll() {
        return Panache.withSession(componentRepository::listAll);
    }

    @Override
    @WithTransaction
    public Uni<Boolean> deleteById(UUID id) {
        return componentRepository.deleteById(id);
    }
}
