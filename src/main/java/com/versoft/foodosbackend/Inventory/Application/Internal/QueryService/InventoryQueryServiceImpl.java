package com.versoft.foodosbackend.Inventory.Application.Internal.QueryService;

import com.versoft.foodosbackend.Inventory.Domain.Model.Aggregates.Inventory;
import com.versoft.foodosbackend.Inventory.Domain.Model.Queries.GetInventoryById;
import com.versoft.foodosbackend.Inventory.Domain.Model.Queries.GetInventorybyIdProfile;
import com.versoft.foodosbackend.Inventory.Domain.Service.InventoryQueryService;
import com.versoft.foodosbackend.Inventory.Infrastructure.Persistence.JPA.repositories.InventoryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InventoryQueryServiceImpl implements InventoryQueryService {

    private final InventoryRepository inventoryRepository;

    public InventoryQueryServiceImpl(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public Optional<Inventory> handle(GetInventorybyIdProfile query) {
        return inventoryRepository.findByIdProfile(query.profileId());
    }

    @Override
    public Optional<Inventory> handle(GetInventoryById query) {
        return  inventoryRepository.findById(query.id());
    }
}
