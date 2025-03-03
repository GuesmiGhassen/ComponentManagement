package com.elyaflow.application.mapper;

import com.elyaflow.application.rest.model.ComponentDTO;
import com.elyaflow.domain.model.Component;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "cdi")
public interface ComponentMapper {

    ComponentMapper INSTANCE = Mappers.getMapper(ComponentMapper.class);

    ComponentDTO toDTO(Component component);

}
