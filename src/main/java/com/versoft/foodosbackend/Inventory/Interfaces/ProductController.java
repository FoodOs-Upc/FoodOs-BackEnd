package com.versoft.foodosbackend.Inventory.Interfaces;

import com.versoft.foodosbackend.Inventory.Domain.Model.Commands.DeleteProductCommand;
import com.versoft.foodosbackend.Inventory.Domain.Model.Commands.GoodStateProductCommand;
import com.versoft.foodosbackend.Inventory.Domain.Model.Queries.GetProductByIdQuery;
import com.versoft.foodosbackend.Inventory.Domain.Service.ProductCommandService;
import com.versoft.foodosbackend.Inventory.Domain.Service.ProductQueryService;
import com.versoft.foodosbackend.Inventory.Interfaces.Rest.Resource.AddProductResource;
import com.versoft.foodosbackend.Inventory.Interfaces.Rest.Resource.ProductResource;
import com.versoft.foodosbackend.Inventory.Interfaces.Rest.Resource.UpdateProductResource;
import com.versoft.foodosbackend.Inventory.Interfaces.Rest.Transform.CreateProductCommandFromResourceAssembler;
import com.versoft.foodosbackend.Inventory.Interfaces.Rest.Transform.ProductResourceFromEntityAssembler;
import com.versoft.foodosbackend.Inventory.Interfaces.Rest.Transform.UpdateProductCommandFromResourceAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/product", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Product", description = "Product Management Endpoints")
public class ProductController {

    private final ProductCommandService productCommandService;
    private final ProductQueryService productQueryService;

    public ProductController(ProductCommandService productCommandService, ProductQueryService productQueryService) {
        this.productCommandService = productCommandService;
        this.productQueryService = productQueryService;
    }

    @PostMapping
    public ResponseEntity<ProductResource> createProduct(@RequestBody AddProductResource addProductResource) {
        var createProductCommand = CreateProductCommandFromResourceAssembler.toCommandFromResource(addProductResource);
        var id = productCommandService.handle(createProductCommand);
        if (id == 0L) {
            return ResponseEntity.badRequest().build();
        }
        var getProductByIdQuery = new GetProductByIdQuery(id);
        var product = productQueryService.handle(getProductByIdQuery);
        if (product.isEmpty()) return ResponseEntity.badRequest().build();
        var productResource = ProductResourceFromEntityAssembler.toResourceFromEntity(product.get());
        return new ResponseEntity<>(productResource, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProductResource>> getAllProduct() {
        var product = productQueryService.handle();
        var productResource = product.stream().map(ProductResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(productResource);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResource> getProductById(@PathVariable Long id) {
        var getProductByIdQuery = new GetProductByIdQuery(id);
        var product = productQueryService.handle(getProductByIdQuery);
        if (product.isEmpty()) return ResponseEntity.badRequest().build();
        var productResource = ProductResourceFromEntityAssembler.toResourceFromEntity(product.get());
        return ResponseEntity.ok(productResource);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResource> updateProduct(@PathVariable Long id, @RequestBody UpdateProductResource updateProductResource) {
        var updateProductCommand = UpdateProductCommandFromResourceAssembler.toCommandFromResource(id, updateProductResource);
        var updateProduct = productCommandService.handle(updateProductCommand);
        if (updateProduct.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var productResource = ProductResourceFromEntityAssembler.toResourceFromEntity(updateProduct.get());
        return ResponseEntity.ok(productResource);
    }

    @DeleteMapping("/{productId}")
    public  ResponseEntity<?> deleteProduct(@PathVariable Long productId){
        var deleteProductCommand = new DeleteProductCommand(productId);
        productCommandService.handle(deleteProductCommand);
        return ResponseEntity.ok("Product deleted successfully");

    }
}
