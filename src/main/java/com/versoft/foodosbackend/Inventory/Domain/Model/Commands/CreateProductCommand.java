package com.versoft.foodosbackend.Inventory.Domain.Model.Commands;

import java.util.Date;

public record CreateProductCommand(
        Long IdInventory,
        byte[] photo,
        String name,
        Date expirationDate,
        Date productionDate
        ) {
}
