package com.versoft.foodosbackend.Inventory.Domain.Service;

import com.versoft.foodosbackend.Inventory.Domain.Model.Commands.CreateInventoryCommand;
import com.versoft.foodosbackend.Inventory.Domain.Model.Commands.CreateProductCommand;

public interface InventoryCommandService {
    Long handle(CreateInventoryCommand command);
}
