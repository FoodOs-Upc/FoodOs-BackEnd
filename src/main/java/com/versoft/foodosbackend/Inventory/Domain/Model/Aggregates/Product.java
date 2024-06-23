package com.versoft.foodosbackend.Inventory.Domain.Model.Aggregates;

import com.versoft.foodosbackend.Inventory.Domain.Model.Commands.CreateProductCommand;
import com.versoft.foodosbackend.Inventory.Domain.Model.ValueObjects.DateProduct;
import com.versoft.foodosbackend.Inventory.Domain.Model.ValueObjects.ProductState;
import com.versoft.foodosbackend.Shared.Domain.Aggregates.AuditableAbstractAggregateRoot;
import com.versoft.foodosbackend.Task.Domain.Model.Aggregates.Task;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

@Entity
public class Product extends AuditableAbstractAggregateRoot<Product> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Getter
    private String photoString;

    @Getter
    private String stateString;

    @Getter
    private String dateString;

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
    public Product (CreateProductCommand command)
    {
        this();
        this.photoString = command.photoString();
        this.stateString = command.stateString();
        this.dateString = command.dateString();
        this.name = command.name();
    }

    public void goodState(){
        this.state= ProductState.GOOD;
    }

    public void badState(){
        this.state= ProductState.BAD;
    }

    public Product updateProductInformation (String photoString, String stateString, String dateString, String name){
        this.photoString = photoString;
        this.stateString = stateString;
        this.dateString = dateString;
        this.name = name;
        return this;
    }
}
