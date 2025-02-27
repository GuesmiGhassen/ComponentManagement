package com.elyaflow.domain.service;

import com.elyaflow.domain.model.Component;
import com.elyaflow.domain.spi.ComponentRepositoryPort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class ComponentService {

    @Inject
    ComponentRepositoryPort componentRepository;

    public Component createComponent(String name) {
        Component component = new Component(name);
        componentRepository.save(component);
        return component;
    }

    public List<Component> getAllComponents() {
        System.out.println(componentRepository.findAll().toString());
        return componentRepository.findAll();
    }

    public Optional<Component> findComponentById(UUID id) {
        return componentRepository.findById(id);
    }

    public Component updateComponent(UUID id, String name) {
        Component component = componentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Component not found"));
        component.setName(name);
        componentRepository.save(component);
        return component;
    }

    public void deleteComponent(UUID id) {
        Component component = componentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Component not found"));
        componentRepository.deleteById(id);
    }
}
