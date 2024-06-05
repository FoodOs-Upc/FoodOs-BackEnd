package com.versoft.foodosbackend.Inventory.Interfaces.Rest.Transform;

import com.versoft.foodosbackend.Inventory.Domain.Model.Commands.CreateProductCommand;
import com.versoft.foodosbackend.Inventory.Interfaces.Rest.Resource.AddProductResource;
import com.versoft.foodosbackend.Inventory.Interfaces.Rest.Resource.ProductResource;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CreateProductCommandFromResourceAssembler {
    public static CreateProductCommand toCommandFromResource(Long idInventory,AddProductResource resource) throws IOException {


        return new CreateProductCommand(
                idInventory,
                resource.file().getBytes(),
                resource.name(),
                resource.expirationDate(),
                resource.productionDate());
    }
}
