package com.versoft.foodosbackend.Inventory.Domain.Service;

import com.versoft.foodosbackend.Inventory.Domain.Model.Aggregates.Inventory;
import com.versoft.foodosbackend.Inventory.Domain.Model.Queries.GetInventoryById;
import com.versoft.foodosbackend.Inventory.Domain.Model.Queries.GetInventorybyIdProfile;

import java.util.Optional;

public interface InventoryQueryService {
    Optional<Inventory> handle(GetInventorybyIdProfile query);
    Optional<Inventory> handle(GetInventoryById query);
}
