package com.versoft.foodosbackend.Profiles.Domain.Services;

import com.versoft.foodosbackend.Profiles.Domain.Model.Commands.CreateProfileCommand;

public interface ProfileCommandService {
    Long handle(CreateProfileCommand command);
}
