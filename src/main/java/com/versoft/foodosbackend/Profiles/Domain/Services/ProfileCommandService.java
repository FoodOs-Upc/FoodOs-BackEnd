package com.versoft.foodosbackend.Profiles.Domain.Services;

import com.versoft.foodosbackend.Profiles.Domain.Model.Commands.CreateProfileCommand;
import com.versoft.foodosbackend.Profiles.Domain.Model.Commands.DeleProductProfileCommand;

public interface ProfileCommandService {
    Long handle(CreateProfileCommand command);
    void handle(DeleProductProfileCommand command);
}
