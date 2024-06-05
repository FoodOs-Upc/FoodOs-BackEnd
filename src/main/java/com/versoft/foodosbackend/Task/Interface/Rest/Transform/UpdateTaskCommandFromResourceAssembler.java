package com.versoft.foodosbackend.Task.Interface.Rest.Transform;

import com.versoft.foodosbackend.Task.Domain.Model.Commands.UpdateTaskCommand;
import com.versoft.foodosbackend.Task.Interface.Rest.Resource.UpdateTaskResource;

public class UpdateTaskCommandFromResourceAssembler {
    public static UpdateTaskCommand toCommandFromResource(Long id, UpdateTaskResource resource) {

        return new UpdateTaskCommand(id, resource.title(), resource.description(), resource.date(), resource.memberasignado());

    }
}