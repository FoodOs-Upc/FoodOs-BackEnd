package com.versoft.foodosbackend.Profiles.Domain.Model.ValueObjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record PersonName(String firstName, String lastName) {
    public PersonName(){
        this(null, null);
    }
    public PersonName{
        if(firstName == null || firstName.isBlank()){
            throw new IllegalArgumentException("The firstname must not be blank");
        }
        if(lastName == null || lastName.isBlank()){
            throw new IllegalArgumentException("The lastname must not be blank");
        }
    }
    public String getFullName(){
        return String.format("%s %s", firstName, lastName);
    }
}
