package com.versoft.foodosbackend.Inventory.Domain.Model.Aggregates;

import com.versoft.foodosbackend.Inventory.Domain.Model.Entities.File;
import com.versoft.foodosbackend.Shared.Domain.Aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "inventories")
public class Inventory extends AuditableAbstractAggregateRoot<Inventory> {
    @Getter
    @OneToMany(mappedBy = "inventory")
    private List<Product> products;

    @Getter
    @OneToMany(mappedBy = "inventory")
    private List<File> files;

    @Getter
    private Long idProfile;

    public Inventory() {

    }

    public Inventory(Long idProfile){
        this.idProfile = idProfile;
        this.products = new ArrayList<Product>();
        this.files=new ArrayList<File>();

    }
}
