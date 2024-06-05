package com.versoft.foodosbackend.Profiles.Domain.Model.Queries;

import com.versoft.foodosbackend.Profiles.Domain.Model.ValueObjects.EmailAddress;

public record GetProfileByEmailQuery(EmailAddress emailAddress) {
}
