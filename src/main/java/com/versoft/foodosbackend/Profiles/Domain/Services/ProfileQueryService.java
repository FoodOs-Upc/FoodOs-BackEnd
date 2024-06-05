package com.versoft.foodosbackend.Profiles.Domain.Services;

import com.versoft.foodosbackend.Profiles.Domain.Model.Aggregates.Profile;
import com.versoft.foodosbackend.Profiles.Domain.Model.Queries.GetProfileByEmailQuery;
import com.versoft.foodosbackend.Profiles.Domain.Model.Queries.GetProfileByIdQuery;

import java.util.Optional;

public interface ProfileQueryService {
    Optional<Profile> handle(GetProfileByEmailQuery query);
    Optional<Profile> handle(GetProfileByIdQuery query);
}
