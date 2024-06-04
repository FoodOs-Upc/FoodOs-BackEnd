package com.versoft.foodosbackend.Inventory.Domain.Model.ValueObjects;

import jakarta.persistence.Embeddable;
import lombok.Getter;


import java.util.Date;

@Embeddable
public record DateProduct(
        @Getter
        Date expirationDate,
        @Getter
        Date productionDate
    ) {



    public DateProduct(){
        this(null,null);
    }

    public DateProduct{

        var datetime = new Date();
        if (expirationDate == null || expirationDate.before(datetime)){
            throw new IllegalArgumentException("The expiration date cannot be before today's date.");
        }
    }




}
