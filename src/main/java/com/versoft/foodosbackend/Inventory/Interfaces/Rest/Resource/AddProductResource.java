package com.versoft.foodosbackend.Inventory.Interfaces.Rest.Resource;

public record AddProductResource(
        String photoString,
        String stateString,
        String dateString,
        String name) {
}
