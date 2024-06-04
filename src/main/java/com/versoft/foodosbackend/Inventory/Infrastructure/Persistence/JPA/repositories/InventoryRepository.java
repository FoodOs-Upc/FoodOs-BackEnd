package com.versoft.foodosbackend.Inventory.Infrastructure.Persistence.JPA.repositories;

import com.versoft.foodosbackend.Inventory.Domain.Model.Aggregates.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory,Long> {
    Optional<Inventory> findByIdProfile(Long idProfile);
    Optional<Inventory> findById(Long id);
    boolean existsByIdProfile(long idProfile);
}
