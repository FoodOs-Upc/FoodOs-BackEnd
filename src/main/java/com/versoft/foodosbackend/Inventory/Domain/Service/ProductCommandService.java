package com.versoft.foodosbackend.Inventory.Domain.Service;

import com.versoft.foodosbackend.Inventory.Domain.Model.Commands.DeleteProductCommand;
import com.versoft.foodosbackend.Inventory.Domain.Model.Commands.GoodStateProductCommand;

public interface ProductCommandService {
    Long handles(GoodStateProductCommand command);
    void handle(DeleteProductCommand command);
}
