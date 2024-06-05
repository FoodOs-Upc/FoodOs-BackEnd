package com.versoft.foodosbackend.Profiles.Domain.Model.ValueObjects;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Email;

@Embeddable
public record EmailAddress(@Email String addres) {
    public EmailAddress(){this(null);}

}
