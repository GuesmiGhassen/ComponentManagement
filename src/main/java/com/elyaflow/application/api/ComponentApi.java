package com.elyaflow.application.api;


import com.elyaflow.domain.model.Component;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Path("/api")
public interface ComponentApi {

    @Operation(summary = "Create a new component", description = "Creates a new component.")
    @APIResponses(value = {
            @APIResponse(responseCode = "201", description = "Component created successfully"),
            @APIResponse(responseCode = "400", description = "Invalid input"),
            @APIResponse(responseCode = "401", description = "Unauthorized"),
            @APIResponse(responseCode = "500", description = "Internal server error")
    })
    @POST
    @Path("/component")
    Response createComponent(
            @Parameter(description = "Component name", required = true)
            String componentName
    );


    @Operation(summary = "Get all components", description = "Returns a list of all components.")
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "List of components")
    })
    @GET
    @Path("/components")
    List<ComponentDTO> getAllComponents();


    @Operation(summary = "Get component by Id", description = "Returns a component by Id.")
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "Component found"),
            @APIResponse(responseCode = "404", description = "Component not found")
    })
    @GET
    @Path("/component/{id}")
    Optional<Component> findComponentById(
            @Parameter(description = "Component ID", required = true)
            @PathParam("id") UUID id
    );


    @Operation(summary = "Update a component", description = "Updates the name of an existing component.")
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "Component updated")
    })
    @PUT
    @Path("/component/update/{id}")
    Component updateComponent(
            @Parameter(description = "Component ID", required = true)
            @PathParam("id") UUID id,
            @Parameter(description = "Updated component name", required = true)
            String name
    );


    @Operation(summary = "Delete a component", description = "Deletes a component by Id.")
    @APIResponses(value = {
            @APIResponse(responseCode = "204", description = "Component deleted"),
            @APIResponse(responseCode = "404", description = "Component not found")
    })
    @DELETE
    @Path("/component/delete/{id}")
    void deleteComponent(
            @Parameter(description = "Component ID", required = true)
            @PathParam("id") UUID id
    );

}
