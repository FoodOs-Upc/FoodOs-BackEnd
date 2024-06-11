package com.versoft.foodosbackend.Profiles.Domain.Services;

import com.versoft.foodosbackend.Profiles.Domain.Model.Aggregates.Profile;
import com.versoft.foodosbackend.Profiles.Domain.Model.Commands.CreateProfileCommand;
import com.versoft.foodosbackend.Profiles.Domain.Model.Commands.DeleProductProfileCommand;
import com.versoft.foodosbackend.Profiles.Domain.Model.Commands.UpdateProfileCommand;

import java.util.Optional;

public interface ProfileCommandService {
    Long handle(CreateProfileCommand command);
    void handle(DeleProductProfileCommand command);
    Optional<Profile> handle(UpdateProfileCommand command);
}
