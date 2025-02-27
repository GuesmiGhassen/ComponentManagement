package com.elyaflow.application.api;

import com.elyaflow.domain.model.Component;

import java.util.List;
import java.util.stream.Collectors;

public class ComponentMapper {

    public static ComponentDTO toDTO(Component component) {
        return new ComponentDTO(
                component.getId(),
                component.getName(),
                component.getCreatedAt(),
                component.getUpdatedAt(),
                component.getModifiedBy()
        );
    }

    public static List<ComponentDTO> toDTOList(List<Component> components) {
        return components.stream().map(ComponentMapper::toDTO).collect(Collectors.toList());
    }
}
