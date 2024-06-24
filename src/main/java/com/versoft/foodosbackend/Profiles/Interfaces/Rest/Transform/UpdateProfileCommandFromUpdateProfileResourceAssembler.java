package com.versoft.foodosbackend.Profiles.Interfaces.Rest.Transform;

import com.versoft.foodosbackend.Profiles.Domain.Model.Commands.UpdateProfileCommand;
import com.versoft.foodosbackend.Profiles.Interfaces.Rest.Resource.UpdateProfileResource;

import java.io.IOException;

public class UpdateProfileCommandFromUpdateProfileResourceAssembler {
    public static UpdateProfileCommand toCommandFromResource(Long profileId,UpdateProfileResource resource) throws IOException {
        return new UpdateProfileCommand(
                profileId,
                resource.imageProfile().getBytes(),
                resource.email(),
                resource.firstName(),
                resource.lastName());
    }
}
