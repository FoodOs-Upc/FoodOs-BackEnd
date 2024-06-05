package com.versoft.foodosbackend.Profiles.Application.Internal.CommandServices;

import com.versoft.foodosbackend.Profiles.Domain.Model.Aggregates.Profile;
import com.versoft.foodosbackend.Profiles.Domain.Model.Commands.CreateProfileCommand;
import com.versoft.foodosbackend.Profiles.Domain.Model.Commands.DeleProductProfileCommand;
import com.versoft.foodosbackend.Profiles.Domain.Model.ValueObjects.EmailAddress;
import com.versoft.foodosbackend.Profiles.Domain.Services.ProfileCommandService;
import com.versoft.foodosbackend.Profiles.Infrastructure.Persistence.JPA.Repositories.ProfileRepository;
import org.springframework.stereotype.Service;

@Service
public class ProfileCommandServiceImpl implements ProfileCommandService {

    private final ProfileRepository profileRepository;

    public ProfileCommandServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public Long handle(CreateProfileCommand command) {
        var emailAddress = new EmailAddress(command.email());

        profileRepository.findProfileByEmailAddress(emailAddress).map( profile -> {
            throw new IllegalArgumentException("Profile with email " + command.email() + "exists");
        });

        var profile = new Profile(command.imageProfile(),
                command.firstName(),
                command.email(),
                command.lastName());
        profileRepository.save(profile);
        return profile.getId();
    }

    @Override
    public void handle(DeleProductProfileCommand command) {
        if(!profileRepository.existsById(command.profileId())){
            throw new IllegalArgumentException("Profile with id " + command.profileId() + "does not exist");
        }

        profileRepository.deleteById(command.profileId());
    }
}
