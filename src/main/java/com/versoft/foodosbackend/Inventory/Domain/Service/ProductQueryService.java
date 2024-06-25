package com.versoft.foodosbackend.Inventory.Domain.Service;

import com.versoft.foodosbackend.Inventory.Domain.Model.Aggregates.Product;
import com.versoft.foodosbackend.Inventory.Domain.Model.Queries.GetProductByIdInventoryId;
import com.versoft.foodosbackend.Inventory.Domain.Model.Queries.GetProductByIdQuery;

import java.util.List;
import java.util.Optional;

public interface ProductQueryService {
    Optional<Product> handle(GetProductByIdInventoryId query);
    Optional<Product> handle(GetProductByIdQuery query);
    List<Product> handle();
}
