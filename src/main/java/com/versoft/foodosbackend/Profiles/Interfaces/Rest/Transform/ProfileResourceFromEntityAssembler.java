package com.versoft.foodosbackend.Profiles.Interfaces.Rest.Transform;

import com.versoft.foodosbackend.Profiles.Domain.Model.Aggregates.Profile;
import com.versoft.foodosbackend.Profiles.Interfaces.Rest.Resource.ProfileResource;

public class ProfileResourceFromEntityAssembler {
    public static ProfileResource toResourceFromEntity(Profile entity){
        return new ProfileResource(entity.getId(),entity.getImageProfile(),entity.getFullName(),entity.getEmailAddress());
    }
}
