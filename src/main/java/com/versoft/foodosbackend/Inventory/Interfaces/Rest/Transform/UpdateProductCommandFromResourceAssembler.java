package com.versoft.foodosbackend.Inventory.Interfaces.Rest.Transform;

import com.versoft.foodosbackend.Inventory.Domain.Model.Commands.UpdateProductCommand;
import com.versoft.foodosbackend.Inventory.Interfaces.Rest.Resource.UpdateProductResource;
import com.versoft.foodosbackend.Task.Domain.Model.Commands.UpdateTaskCommand;
import com.versoft.foodosbackend.Task.Interface.Rest.Resource.UpdateTaskResource;

public class UpdateProductCommandFromResourceAssembler {
    public static UpdateProductCommand toCommandFromResource(Long id, UpdateProductResource resource) {
        return new UpdateProductCommand(id, resource.photoString(), resource.stateString(), resource.dateString(), resource.name());
    }
}