package com.versoft.foodosbackend.Inventory.Interfaces;

import com.versoft.foodosbackend.Inventory.Domain.Model.Queries.GetInventoryByIdQuery;
import com.versoft.foodosbackend.Inventory.Domain.Model.Queries.GetInventorybyIdProfileQuery;
import com.versoft.foodosbackend.Inventory.Domain.Model.ValueObjects.ProfileId;
import com.versoft.foodosbackend.Inventory.Domain.Service.InventoryCommandService;
import com.versoft.foodosbackend.Inventory.Domain.Service.InventoryQueryService;
import com.versoft.foodosbackend.Inventory.Interfaces.Rest.Resource.AddProductResource;
import com.versoft.foodosbackend.Inventory.Interfaces.Rest.Resource.CreateInventoryResource;
import com.versoft.foodosbackend.Inventory.Interfaces.Rest.Resource.InventoryResource;
import com.versoft.foodosbackend.Inventory.Interfaces.Rest.Resource.ProductResource;
import com.versoft.foodosbackend.Inventory.Interfaces.Rest.Transform.CreateInventoryCommandFromResourceAssembler;
import com.versoft.foodosbackend.Inventory.Interfaces.Rest.Transform.CreateProductCommandFromResourceAssembler;
import com.versoft.foodosbackend.Inventory.Interfaces.Rest.Transform.InventoryResourceFromEntityAssembler;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/inventory", produces = APPLICATION_JSON_VALUE)
public class InventoryController {

    private final InventoryQueryService inventoryQueryService;
    private final InventoryCommandService inventoryCommandService;

    public InventoryController(InventoryQueryService inventoryQueryService, InventoryCommandService inventoryCommandService) {
        this.inventoryQueryService = inventoryQueryService;

        this.inventoryCommandService = inventoryCommandService;
    }

    @GetMapping("/{profileId}")
    public ResponseEntity<InventoryResource> getInventory(@PathVariable Long profileId) {

        var getInventorybyIdProfile = new GetInventorybyIdProfileQuery(new ProfileId(profileId));

        var inventory = inventoryQueryService.handle(getInventorybyIdProfile);


        if(inventory.isEmpty()) return ResponseEntity.notFound().build();

        var inventoryResource = InventoryResourceFromEntityAssembler.toResourceFromEntity(inventory.get());

        return ResponseEntity.ok(inventoryResource);
    }

    @PostMapping
    public ResponseEntity<InventoryResource> createInventory(@RequestBody CreateInventoryResource resource) throws IOException {
        var createInventoryCommand = CreateInventoryCommandFromResourceAssembler.toCommandFromResource(resource);
        var inventoryId = inventoryCommandService.handle(createInventoryCommand);
        if(inventoryId==0L) return ResponseEntity.badRequest().build();

        var getInventoryById = new GetInventoryByIdQuery(inventoryId);
        var inventory = inventoryQueryService.handle(getInventoryById);
        if (inventory.isEmpty()) return ResponseEntity.badRequest().build();
        var inventoryResource = InventoryResourceFromEntityAssembler.toResourceFromEntity(inventory.get());

        return ResponseEntity.ok(inventoryResource);
    }

    @PostMapping(value = "/{id}/product", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InventoryResource> addProduct(
            @PathVariable Long id,
            @ModelAttribute AddProductResource resource) throws IOException {

        var createProductCommand = CreateProductCommandFromResourceAssembler.toCommandFromResource(id,resource);
        var inventoryId = inventoryCommandService.handle(createProductCommand);


        var getInventoryById = new GetInventoryByIdQuery(inventoryId);
        var inventory = inventoryQueryService.handle(getInventoryById);
        if(inventory.isEmpty()) return ResponseEntity.badRequest().build();
        var inventoryResource = InventoryResourceFromEntityAssembler.toResourceFromEntity(inventory.get());
        return ResponseEntity.ok(inventoryResource);

    }



}
