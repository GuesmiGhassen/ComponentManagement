package com.elyaflow.application.rest;

import com.elyaflow.application.rest.model.RequestDTO;
import io.smallrye.mutiny.Uni;
import jakarta.validation.Valid;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

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
    Uni<Response> createComponent(
            @RequestBody @Valid RequestDTO componentDto
    );


    @Operation(summary = "Get all components", description = "Returns a list of all components.")
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "List of components")
    })
    @GET
    @Path("/components")
    Uni<Response> getAllComponents();


    @Operation(summary = "Get component by Id", description = "Returns a component by Id.")
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "Component found"),
            @APIResponse(responseCode = "404", description = "Component not found")
    })
    @GET
    @Path("/component/{id}")
    Uni<Response> findComponentById(
            @Parameter(description = "Component ID", required = true)
            @PathParam("id") UUID id
    );


    @Operation(summary = "Update a component", description = "Updates the name of an existing component.")
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "Component updated")
    })
    @PUT
    @Path("/component/update/{id}")
    Uni<Response> updateComponent(
            @Parameter(description = "Component ID", required = true)
            @PathParam("id") UUID id,
            @RequestBody @Valid RequestDTO componentDto
    );


    @Operation(summary = "Delete a component", description = "Deletes a component by Id.")
    @APIResponses(value = {
            @APIResponse(responseCode = "204", description = "Component deleted"),
            @APIResponse(responseCode = "404", description = "Component not found")
    })
    @DELETE
    @Path("/component/delete/{id}")
    Uni<Response> deleteComponent(
            @Parameter(description = "Component ID", required = true)
            @PathParam("id") UUID id
    );

}
