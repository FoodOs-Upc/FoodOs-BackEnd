package com.versoft.foodosbackend.Inventory.Interfaces.Rest.Transform;

import com.versoft.foodosbackend.Inventory.Domain.Model.Commands.CreateInventoryCommand;
import com.versoft.foodosbackend.Inventory.Interfaces.Rest.Resource.CreateInventoryResource;

import java.io.IOException;

public class CreateInventoryCommandFromResourceAssembler {
    public static CreateInventoryCommand toCommandFromResource(CreateInventoryResource resource) throws IOException{
        return new CreateInventoryCommand(resource.id());
    }
}
