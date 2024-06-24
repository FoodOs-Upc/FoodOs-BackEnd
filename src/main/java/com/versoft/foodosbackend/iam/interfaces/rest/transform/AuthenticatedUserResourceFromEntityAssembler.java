package com.versoft.foodosbackend.iam.interfaces.rest.transform;


import com.versoft.foodosbackend.iam.domain.model.aggregates.User;
import com.versoft.foodosbackend.iam.interfaces.rest.resources.AuthenticatedUserResource;

public class AuthenticatedUserResourceFromEntityAssembler {
    public static AuthenticatedUserResource toResourceFromEntity(User user, String token) {
        return new AuthenticatedUserResource(user.getId(), user.getUsername(), token,user.getProfileId().profileId());
    }
}