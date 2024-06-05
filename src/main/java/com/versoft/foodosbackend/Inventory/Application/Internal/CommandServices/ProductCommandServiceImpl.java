package com.versoft.foodosbackend.Inventory.Application.Internal.CommandServices;

import com.versoft.foodosbackend.Inventory.Domain.Service.ProductCommandService;
import com.versoft.foodosbackend.Inventory.Infrastructure.Persistence.JPA.repositories.ProductRepository;
import com.versoft.foodosbackend.Profiles.Domain.Model.Commands.CreateProfileCommand;
import org.springframework.stereotype.Service;

@Service
public class ProductCommandServiceImpl implements ProductCommandService {

    private final ProductRepository productRepository;

    public ProductCommandServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Long handle(CreateProfileCommand command) {

        return null;
    }
}
