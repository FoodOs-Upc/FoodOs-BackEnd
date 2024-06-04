package com.versoft.foodosbackend.Inventory.Application.Internal.CommandServices;

import com.versoft.foodosbackend.Inventory.Domain.Model.Aggregates.Inventory;
import com.versoft.foodosbackend.Inventory.Domain.Model.Commands.CreateInventoryCommand;
import com.versoft.foodosbackend.Inventory.Domain.Service.InventoryCommandService;
import com.versoft.foodosbackend.Inventory.Infrastructure.Persistence.JPA.repositories.InventoryRepository;
import org.springframework.stereotype.Service;

@Service
public class InventoryCommandServiceImpl implements InventoryCommandService {

    private final InventoryRepository inventoryRepository;

    public InventoryCommandServiceImpl(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public Long handle(CreateInventoryCommand command) {
        System.out.println("MUESTRA " + command.id());

        if(inventoryRepository.existsByIdProfile(command.id())){
            throw new IllegalArgumentException("the profile already has an inventory");
        }

        var inventory = new Inventory(command.id());


        inventoryRepository.save(inventory);
        return inventory.getId();
    }
}
