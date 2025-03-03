package com.elyaflow.application.rest;

import com.elyaflow.application.ApiResponse;
import com.elyaflow.application.ApiResponseBuilder;
import com.elyaflow.application.mapper.ComponentMapper;
import com.elyaflow.application.rest.model.RequestDTO;
import com.elyaflow.domain.model.Component;
import com.elyaflow.domain.service.ComponentService;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@RequestScoped
@RequiredArgsConstructor
public class ComponentController implements ComponentApi {

    private final ComponentService componentService;
    private final ComponentMapper componentMapper;
    private final ApiResponseBuilder apiResponseBuilder;

    @Override
    public Uni<Response> createComponent(RequestDTO componentDto) {
        return componentService.createComponent(componentDto.getName())
                .map(createdComponent -> apiResponseBuilder.buildSuccessResponse(componentMapper.toDTO(createdComponent)))
                .onFailure().recoverWithItem(throwable -> apiResponseBuilder.buildErrorResponse(throwable, "Failed to create component: "));
    }

    @Override
    public Uni<Response> getAllComponents() {
        return componentService.getAllComponents()
                .map(components -> apiResponseBuilder.buildSuccessResponse(componentMapper.toDTO((Component) components)))
                .onFailure().recoverWithItem(throwable -> apiResponseBuilder.buildErrorResponse(throwable, "Failed to get all components: "));
    }

    @Override
    public Uni<Response> findComponentById(UUID id) {
        return componentService.findComponentById(id)
                .map(component -> apiResponseBuilder.buildSuccessResponse(componentMapper.toDTO(component)))
                .onFailure().recoverWithItem(throwable -> apiResponseBuilder.buildErrorResponse(throwable, "Failed to find component: "));
    }

    @Override
    public Uni<Response> updateComponent(UUID id, RequestDTO componentDto) {
        return componentService.updateComponent(id, componentDto.getName())
                .map(updatedComponent -> apiResponseBuilder.buildSuccessResponse(componentMapper.toDTO(updatedComponent)))
                .onFailure().recoverWithItem(throwable -> apiResponseBuilder.buildErrorResponse(throwable, "Failed to update component: "));
    }

    @Override
    public Uni<Response> deleteComponent(UUID id) {
        return componentService.deleteComponent(id)
                .map(apiResponseBuilder::buildSuccessResponse)
                .onFailure().recoverWithItem(throwable -> apiResponseBuilder.buildErrorResponse(throwable, "Failed to delete component: "));
    }
}
