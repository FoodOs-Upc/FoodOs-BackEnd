package com.versoft.foodosbackend.Inventory.Domain.Model.Aggregates;

import com.versoft.foodosbackend.Inventory.Domain.Model.ValueObjects.DateProduct;
import com.versoft.foodosbackend.Shared.Domain.Aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;

@Entity
public class Product extends AuditableAbstractAggregateRoot<Product> {

    private String name;
    private String state;

    @Embedded
    private DateProduct dateProduct;


}
