package com.versoft.foodosbackend.Inventory.Application.Internal.QueryService;

import com.versoft.foodosbackend.Inventory.Domain.Model.Aggregates.Inventory;
import com.versoft.foodosbackend.Inventory.Domain.Model.Queries.GetInventoryByIdQuery;
import com.versoft.foodosbackend.Inventory.Domain.Model.Queries.GetInventorybyIdProfileQuery;
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
    public Optional<Inventory> handle(GetInventorybyIdProfileQuery query) {
        return  inventoryRepository.findByProfileId(query.profileId());
    }

    @Override
    public Optional<Inventory> handle(GetInventoryByIdQuery query) {
        return  inventoryRepository.findById(query.id());
    }
}
