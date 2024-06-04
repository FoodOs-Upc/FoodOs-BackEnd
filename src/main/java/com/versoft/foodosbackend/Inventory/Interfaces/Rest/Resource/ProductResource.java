package com.versoft.foodosbackend.Inventory.Interfaces.Rest.Resource;

import java.util.Date;

public record ProductResource(
        Long id,
        String name ,
        String state,
        Date expirationDate,
        Date productionDate ) {
}
