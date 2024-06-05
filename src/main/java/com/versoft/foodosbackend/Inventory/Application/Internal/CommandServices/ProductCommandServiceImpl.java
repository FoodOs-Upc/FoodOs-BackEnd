package com.versoft.foodosbackend.Inventory.Application.Internal.CommandServices;

import com.versoft.foodosbackend.Inventory.Domain.Model.Commands.DeleteProductCommand;
import com.versoft.foodosbackend.Inventory.Domain.Model.Commands.GoodStateProductCommand;
import com.versoft.foodosbackend.Inventory.Domain.Service.ProductCommandService;
import com.versoft.foodosbackend.Inventory.Infrastructure.Persistence.JPA.repositories.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductCommandServiceImpl implements ProductCommandService {

    private final ProductRepository productRepository;

    public ProductCommandServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


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
    public void handle(DeleteProductCommand command) {
        if(!productRepository.existsById(command.ProductId())){
            throw new IllegalArgumentException("The product does not exist");
        }
        productRepository.deleteById(command.ProductId());

    }
}
