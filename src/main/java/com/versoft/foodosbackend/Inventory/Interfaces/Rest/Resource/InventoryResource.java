package com.versoft.foodosbackend.Inventory.Interfaces.Rest.Resource;

import com.versoft.foodosbackend.Inventory.Domain.Model.Aggregates.Product;
import com.versoft.foodosbackend.Inventory.Domain.Model.Entities.File;

import java.util.List;

public record InventoryResource(Long id, List<ProductResource> products,List<FileResource> files,Long idProfile) {
}
