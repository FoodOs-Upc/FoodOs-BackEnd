package com.versoft.foodosbackend.Inventory.Domain.Service;

import com.versoft.foodosbackend.Inventory.Domain.Model.Aggregates.Inventory;
import com.versoft.foodosbackend.Inventory.Domain.Model.Queries.GetInventoryByIdQuery;
import com.versoft.foodosbackend.Inventory.Domain.Model.Queries.GetInventorybyIdProfileQuery;

import java.util.Optional;

public interface InventoryQueryService {
    Optional<Inventory> handle(GetInventorybyIdProfileQuery query);
    Optional<Inventory> handle(GetInventoryByIdQuery query);
}
