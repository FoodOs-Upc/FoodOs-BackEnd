package com.versoft.foodosbackend.iam.application.internal.outboundservices.acl;

import com.versoft.foodosbackend.Inventory.Interfaces.acl.InventoryContextFacade;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExternalInventoryService {
    private final InventoryContextFacade inventoryContextFacade;

    public ExternalInventoryService(InventoryContextFacade inventoryContextFacade) {
        this.inventoryContextFacade = inventoryContextFacade;
    }

    public Optional<?> createInventory(String email){
        var inventory = inventoryContextFacade.createInventory(email);
        if (inventory == 0L) return Optional.empty();
        return Optional.empty();
    }
}
