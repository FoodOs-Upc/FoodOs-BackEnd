package com.versoft.foodosbackend.Inventory.Domain.Model.Aggregates;

import com.versoft.foodosbackend.Inventory.Domain.Model.ValueObjects.DateProduct;
import com.versoft.foodosbackend.Inventory.Domain.Model.ValueObjects.ProductState;
import com.versoft.foodosbackend.Shared.Domain.Aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

@Entity
public class Product extends AuditableAbstractAggregateRoot<Product> {
    @Lob
    @Column(length = 5000000)
    @Getter
    private byte[] photo;

    @Getter
    private String name;

    @Getter
    private ProductState state;

    @Getter
    @Embedded
    private DateProduct dateProduct;


    @ManyToOne
    @JoinColumn(name = "inventory_id")
    private Inventory inventory;

    public Product(){

    }

    public Product(byte[] photo,String name,DateProduct dateProduct,Inventory inventory) {
        this.photo=photo;
        this.name= name;
        this.state = ProductState.APPROXIMATELY;
        this.dateProduct= dateProduct;
        this.inventory=inventory;

    }

    public void goodState(){
        this.state= ProductState.GOOD;
    }

    public void badState(){
        this.state= ProductState.BAD;
    }


}
