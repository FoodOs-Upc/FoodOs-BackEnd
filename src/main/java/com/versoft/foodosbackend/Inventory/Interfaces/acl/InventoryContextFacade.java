package com.versoft.foodosbackend.Inventory.Interfaces.acl;

import com.versoft.foodosbackend.Inventory.Domain.Model.Aggregates.Inventory;
import com.versoft.foodosbackend.Inventory.Domain.Model.Commands.CreateInventoryCommand;
import com.versoft.foodosbackend.Inventory.Domain.Service.InventoryCommandService;
import com.versoft.foodosbackend.Inventory.Domain.Service.InventoryQueryService;
import org.springframework.stereotype.Service;

@Service
public class InventoryContextFacade {
    private final InventoryCommandService inventoryCommandService;
    private final InventoryQueryService inventoryQueryService;

    public InventoryContextFacade(InventoryCommandService inventoryCommandService, InventoryQueryService inventoryQueryService) {
        this.inventoryCommandService = inventoryCommandService;
        this.inventoryQueryService = inventoryQueryService;
    }

    public Long createInventory(String email) {

        var createInventoryCommand = new CreateInventoryCommand(email);
        return inventoryCommandService.handle(createInventoryCommand);
    }
}
