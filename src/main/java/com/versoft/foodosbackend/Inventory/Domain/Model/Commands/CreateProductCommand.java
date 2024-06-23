package com.versoft.foodosbackend.Inventory.Domain.Model.Commands;

import java.util.Date;

public record CreateProductCommand(
        String photoString,
        String stateString,
        String dateString,
        String name,
        Date expirationDate,
        Date productionDate
        ) {
}
