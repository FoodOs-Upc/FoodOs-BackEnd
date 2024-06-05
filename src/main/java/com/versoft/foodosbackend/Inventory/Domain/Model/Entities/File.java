package com.versoft.foodosbackend.Inventory.Domain.Model.Entities;

import com.versoft.foodosbackend.Inventory.Domain.Model.Aggregates.Inventory;
import com.versoft.foodosbackend.Shared.Domain.Entities.AuditableModel;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
public class File extends AuditableModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Lob
    @Getter
    @Column(length = 500000)
    private byte[] file;

    @Getter
    private String fileName;

    @Getter
    private String type;

    @ManyToOne
    @JoinColumn(name = "inventory_id")
    private Inventory inventory;

    public File() {}

    public File(byte[] file,String fileName, String type) {
        this.file = file;
        this.fileName = fileName;
        this.type = type;
    }

}
