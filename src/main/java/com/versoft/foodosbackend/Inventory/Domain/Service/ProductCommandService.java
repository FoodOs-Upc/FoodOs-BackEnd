package com.versoft.foodosbackend.Inventory.Domain.Service;

import com.versoft.foodosbackend.Inventory.Domain.Model.Aggregates.Product;
import com.versoft.foodosbackend.Inventory.Domain.Model.Commands.CreateProductCommand;
import com.versoft.foodosbackend.Inventory.Domain.Model.Commands.DeleteProductCommand;
import com.versoft.foodosbackend.Inventory.Domain.Model.Commands.GoodStateProductCommand;
import com.versoft.foodosbackend.Inventory.Domain.Model.Commands.UpdateProductCommand;

import java.util.Optional;

public interface ProductCommandService {
    Long handles(GoodStateProductCommand command);
    Long handle (CreateProductCommand command);
    Optional<Product> handle (UpdateProductCommand command);
    void handle (DeleteProductCommand command);
}
