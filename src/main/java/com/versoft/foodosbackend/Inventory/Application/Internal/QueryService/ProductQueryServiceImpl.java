package com.versoft.foodosbackend.Inventory.Application.Internal.QueryService;

import com.versoft.foodosbackend.Inventory.Domain.Model.Aggregates.Product;
import com.versoft.foodosbackend.Inventory.Domain.Model.Queries.GetProductByIdInventoryId;
import com.versoft.foodosbackend.Inventory.Domain.Model.Queries.GetProductByIdQuery;
import com.versoft.foodosbackend.Inventory.Domain.Service.ProductQueryService;
import com.versoft.foodosbackend.Inventory.Infrastructure.Persistence.JPA.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductQueryServiceImpl implements ProductQueryService {
    private final ProductRepository productRepository;

    public ProductQueryServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Optional<Product> handle(GetProductByIdInventoryId query) {
        return productRepository.findByInventoryId(query.IdInventory());
    }

    @Override
    public Optional<Product> handle(GetProductByIdQuery query) {
        return productRepository.findById(query.id());
    }
}
