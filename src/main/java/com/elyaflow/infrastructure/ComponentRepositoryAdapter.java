package com.elyaflow.infrastructure;

import com.elyaflow.domain.model.Component;
import com.elyaflow.domain.spi.ComponentRepositoryPort;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class ComponentRepositoryAdapter implements ComponentRepositoryPort {

    @Inject
    JpaComponentRepository componentRepository;

    @Override
    public void save(Component component) {
        componentRepository.save(component);
    }

    @Override
    public Optional<Component> findById(UUID id) {
        return componentRepository.findById(id);
    }

    @Override
    public List<Component> findAll() {
        return componentRepository.findAll();
    }

    @Override
    public void deleteById(UUID id) {
        componentRepository.deleteById(id);
    }
}
