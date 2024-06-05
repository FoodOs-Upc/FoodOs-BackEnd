package com.versoft.foodosbackend.Inventory.Domain.Model.ValueObjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record ProfileId(Long profileId) {
    public ProfileId() {this(0L);}

    public ProfileId{
        if(profileId < 0){
            throw new IllegalArgumentException("Profile id cannot be negative");
        }
    }
}
