package com.versoft.foodosbackend.Inventory.Interfaces.Rest.Transform;

import com.versoft.foodosbackend.Inventory.Domain.Model.Aggregates.Product;
import com.versoft.foodosbackend.Inventory.Interfaces.Rest.Resource.ProductResource;
import com.versoft.foodosbackend.Task.Domain.Model.Aggregates.Task;
import com.versoft.foodosbackend.Task.Interface.Rest.Resource.TaskResource;

public class ProductResourceFromEntityAssembler {
    public static ProductResource toResourceFromEntity(Product entity) {
        return new ProductResource(entity.getPhotoString(), entity.getStateString(), entity.getDateString(), entity.getId(), entity.getName());
    }
}