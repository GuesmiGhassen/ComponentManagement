package com.elyaflow.application.api;

import com.elyaflow.domain.model.Component;
import com.elyaflow.domain.service.ComponentService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ComponentController implements ComponentApi {

    @Inject
    ComponentService componentService;

    @Override
    public Response createComponent(String componentName) {
        Component component = componentService.createComponent(componentName);
        return Response.status(Response.Status.CREATED).entity(component).build();
    }

    @Override
    public List<ComponentDTO> getAllComponents() {
        return ComponentMapper.toDTOList(componentService.getAllComponents());
    }

    @Override
    public Optional<Component> findComponentById(UUID id) {
        return componentService.findComponentById(id);
    }

    @Override
    public Component updateComponent(UUID id, String componentName) {
        return componentService.updateComponent(id, componentName);
    }

    @Override
    public void deleteComponent(UUID id) {
        componentService.deleteComponent(id);
    }
}
