package com.versoft.foodosbackend.Inventory.Interfaces.Rest.Resource;

public record FileResource(
        Long id,
        byte[] file,
        String fileName,
        String type) {
}
