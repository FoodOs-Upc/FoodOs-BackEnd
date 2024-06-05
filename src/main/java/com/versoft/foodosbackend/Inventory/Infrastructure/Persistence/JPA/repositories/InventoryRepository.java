package com.versoft.foodosbackend.Inventory.Infrastructure.Persistence.JPA.repositories;

import com.versoft.foodosbackend.Inventory.Domain.Model.Aggregates.Inventory;
import com.versoft.foodosbackend.Inventory.Domain.Model.ValueObjects.ProfileId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory,Long> {
    Optional<Inventory> findByProfileId(ProfileId profileId);
    Optional<Inventory> findById(Long id);
}
