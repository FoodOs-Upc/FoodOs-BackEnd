package com.versoft.foodosbackend.Inventory.Interfaces;

import com.versoft.foodosbackend.Inventory.Domain.Model.Commands.DeleteProductCommand;
import com.versoft.foodosbackend.Inventory.Domain.Model.Commands.GoodStateProductCommand;
import com.versoft.foodosbackend.Inventory.Domain.Service.ProductCommandService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/product", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Product", description = "Product Management Endpoints")
public class ProductController {

    private  final ProductCommandService productCommandService;

    public ProductController(ProductCommandService productCommandService) {
        this.productCommandService = productCommandService;
    }


    @PutMapping("/{productId}/good")
    public ResponseEntity<?> addProduct(@PathVariable Long productId) {
        var goodStateProductCommand = new GoodStateProductCommand(productId);

        var idProduct = productCommandService.handles(goodStateProductCommand);

        return ResponseEntity.ok().body(idProduct);
    }

    @DeleteMapping("/{productId}")
    public  ResponseEntity<?> deleteProduct(@PathVariable Long productId){
        var deleteProductCommand = new DeleteProductCommand(productId);
        this.productCommandService.handle(deleteProductCommand);
        return ResponseEntity.ok("Product deleted successfully");

    }
}
