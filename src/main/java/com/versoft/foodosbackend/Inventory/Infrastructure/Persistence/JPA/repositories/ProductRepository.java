package com.versoft.foodosbackend.Inventory.Infrastructure.Persistence.JPA.repositories;

import com.versoft.foodosbackend.Inventory.Domain.Model.Aggregates.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    Optional<Product> findById(Long id);
    Optional<Product> findByInventoryId(Long idInventory);

}
