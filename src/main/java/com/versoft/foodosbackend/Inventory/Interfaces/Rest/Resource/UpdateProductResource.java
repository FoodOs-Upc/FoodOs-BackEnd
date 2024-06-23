package com.versoft.foodosbackend.Inventory.Interfaces.Rest.Resource;

public record UpdateProductResource(String photoString,
                                    String stateString,
                                    String dateString,
                                    String name) {
}