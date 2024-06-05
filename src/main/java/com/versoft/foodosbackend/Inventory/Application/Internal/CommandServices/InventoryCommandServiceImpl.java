package com.versoft.foodosbackend.Inventory.Application.Internal.CommandServices;

import com.versoft.foodosbackend.Inventory.Application.Internal.Outboundservices.acl.ExternalProfileService;
import com.versoft.foodosbackend.Inventory.Domain.Model.Aggregates.Inventory;
import com.versoft.foodosbackend.Inventory.Domain.Model.Aggregates.Product;
import com.versoft.foodosbackend.Inventory.Domain.Model.Commands.CreateInventoryCommand;
import com.versoft.foodosbackend.Inventory.Domain.Model.Commands.CreateProductCommand;
import com.versoft.foodosbackend.Inventory.Domain.Model.ValueObjects.DateProduct;
import com.versoft.foodosbackend.Inventory.Domain.Service.InventoryCommandService;
import com.versoft.foodosbackend.Inventory.Infrastructure.Persistence.JPA.repositories.InventoryRepository;
import com.versoft.foodosbackend.Inventory.Infrastructure.Persistence.JPA.repositories.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class InventoryCommandServiceImpl implements InventoryCommandService {

    private final InventoryRepository inventoryRepository;
    private final ProductRepository productRepository;
    private final ExternalProfileService externalProfileService;

    public InventoryCommandServiceImpl(InventoryRepository inventoryRepository, ProductRepository productRepository, ExternalProfileService externalProfileService) {
        this.inventoryRepository = inventoryRepository;
        this.productRepository = productRepository;
        this.externalProfileService = externalProfileService;
    }

    @Override
    public Long handle(CreateInventoryCommand command) {

        var profileId = externalProfileService.fetchProfileIdByEmail(command.email());

        if(profileId.isEmpty()){
            throw new IllegalArgumentException("There is no inventory with that email");
        }else {
            inventoryRepository.findByProfileId(profileId.get()).ifPresent( inventory -> {
                throw new IllegalArgumentException("Inventory alredy exists");
            });
        }


        var inventory = new Inventory(profileId.get());

        inventoryRepository.save(inventory);
        return inventory.getId();
    }

    @Override
    public Long handle(CreateProductCommand command) {

        var inventoryQuery = inventoryRepository.findById(command.IdInventory());

        if(inventoryQuery.isEmpty()){
            throw new IllegalArgumentException("No exist inventory");
        }
        var inventory = inventoryQuery.get();

        var product = new Product(command.photo(),command.name(), new DateProduct(command.expirationDate(), command.productionDate()),inventory);

        inventory.addNewProduc(product);

        inventoryRepository.save(inventory);
        productRepository.save(product);

        return inventory.getId();




    }
}
