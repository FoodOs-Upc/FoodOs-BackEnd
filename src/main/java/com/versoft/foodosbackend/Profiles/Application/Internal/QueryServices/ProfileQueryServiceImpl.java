package com.versoft.foodosbackend.Profiles.Application.Internal.QueryServices;

import com.versoft.foodosbackend.Profiles.Domain.Model.Aggregates.Profile;
import com.versoft.foodosbackend.Profiles.Domain.Model.Queries.GetProfileByEmailQuery;
import com.versoft.foodosbackend.Profiles.Domain.Model.Queries.GetProfileByIdQuery;
import com.versoft.foodosbackend.Profiles.Domain.Services.ProfileQueryService;
import com.versoft.foodosbackend.Profiles.Infrastructure.Persistence.JPA.Repositories.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileQueryServiceImpl implements ProfileQueryService {

    private final ProfileRepository profileRepository;

    public ProfileQueryServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public Optional<Profile> handle(GetProfileByEmailQuery query) {
        return profileRepository.findProfileByEmailAddress(query.emailAddress());
    }

    @Override
    public Optional<Profile> handle(GetProfileByIdQuery query) {
        return profileRepository.findById(query.profileId());
    }
}
