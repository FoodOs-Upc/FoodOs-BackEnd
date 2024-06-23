package com.versoft.foodosbackend.Inventory.Application.Internal.CommandServices;

import com.versoft.foodosbackend.Inventory.Domain.Model.Aggregates.Product;
import com.versoft.foodosbackend.Inventory.Domain.Model.Commands.CreateProductCommand;
import com.versoft.foodosbackend.Inventory.Domain.Model.Commands.DeleteProductCommand;
import com.versoft.foodosbackend.Inventory.Domain.Model.Commands.GoodStateProductCommand;
import com.versoft.foodosbackend.Inventory.Domain.Model.Commands.UpdateProductCommand;
import com.versoft.foodosbackend.Inventory.Domain.Service.ProductCommandService;
import com.versoft.foodosbackend.Inventory.Infrastructure.Persistence.JPA.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ProductCommandServiceImpl implements ProductCommandService {

    private final ProductRepository productRepository;
    public ProductCommandServiceImpl(ProductRepository productRepository) { this.productRepository = productRepository; }

    @Override
    public Long handles(GoodStateProductCommand command) {

        this.productRepository.findById(command.productId()).map(product -> {
            product.goodState();
            this.productRepository.save(product);
            return product.getId();

        });
        return null;
    }

    @Override
    public Long handle(CreateProductCommand command) {
        Product product = new Product(command);
        try{
            productRepository.save(product);
        } catch(Exception e){
            throw new IllegalArgumentException("Error while saving product" + e.getMessage());
        }
        return product.getId();
    }

    @Override
    public Optional<Product> handle (UpdateProductCommand command) {
        var result = productRepository.findById(command.id());
        if(result.isEmpty()) throw new IllegalArgumentException("Product does not exist");
        var productToUpdate = result.get();
        try{
            var updatedTask = productRepository.save(productToUpdate.updateProductInformation(command.photoString(), command.photoString(), command.dateString(), command.name()));
            return Optional.of(updatedTask);
        } catch(Exception e){
            throw new IllegalArgumentException("Error while saving task" + e.getMessage());
        }
    }

    @Override
    public void handle(DeleteProductCommand command) {
        if(!productRepository.existsById(command.ProductId())){
            throw new IllegalArgumentException("The product does not exist");
        }
        productRepository.deleteById(command.ProductId());

    }
}
