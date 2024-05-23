package com.versoft.foodosbackend.Profiles.Interfaces.Rest.Transform;

import com.versoft.foodosbackend.Profiles.Domain.Model.Commands.CreateProfileCommand;
import com.versoft.foodosbackend.Profiles.Interfaces.Rest.Resource.CreateProfileResource;

import java.io.IOException;

public class CreateProfileCommandFromResourceAssembler {
    public static CreateProfileCommand toCommandFromResource(CreateProfileResource resource) throws IOException {
        return new CreateProfileCommand(
                resource.imageProfile().getBytes(),
                resource.emailAddress(),
                resource.firstName(),
                resource.LastName());
    }
}
