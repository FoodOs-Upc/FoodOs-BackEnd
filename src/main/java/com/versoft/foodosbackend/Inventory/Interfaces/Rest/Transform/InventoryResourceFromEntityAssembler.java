package com.versoft.foodosbackend.Inventory.Interfaces.Rest.Transform;

import com.versoft.foodosbackend.Inventory.Domain.Model.Aggregates.Inventory;
import com.versoft.foodosbackend.Inventory.Domain.Model.Aggregates.Product;
import com.versoft.foodosbackend.Inventory.Interfaces.Rest.Resource.FileResource;
import com.versoft.foodosbackend.Inventory.Interfaces.Rest.Resource.InventoryResource;
import com.versoft.foodosbackend.Inventory.Interfaces.Rest.Resource.ProductResource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InventoryResourceFromEntityAssembler {
    public static InventoryResource toResourceFromEntity(Inventory entity){

        List<ProductResource> productResources = entity.getProducts().stream()
                .map(product -> new ProductResource(
                        product.getPhotoString(),
                        product.getStateString(),
                        product.getDateString(),
                        product.getId(),
                        product.getName()))
                .collect(Collectors.toList());

        List<FileResource> fileResourceList = entity.getFiles().stream()
                .map(file -> new FileResource(
                        file.getId(),
                        file.getFile(),
                        file.getFileName(),
                        file.getType()
                ))
                .toList();

        return new InventoryResource(entity.getId(),productResources,fileResourceList,entity.getProfileId());
    }
}
