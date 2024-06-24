package com.versoft.foodosbackend.Inventory.Domain.Model.Commands;

public record UpdateProductCommand(Long id,
                                   String photoString,
                                   String stateString,
                                   String dateString,
                                   String name) {
}
