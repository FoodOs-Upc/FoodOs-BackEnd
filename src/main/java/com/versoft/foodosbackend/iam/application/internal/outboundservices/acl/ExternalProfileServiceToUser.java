package com.versoft.foodosbackend.iam.application.internal.outboundservices.acl;


import com.versoft.foodosbackend.Profiles.Interfaces.acl.ProfilesContextFacade;
import com.versoft.foodosbackend.iam.domain.model.valueobjects.ProfileId;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExternalProfileServiceToUser {

    private final ProfilesContextFacade profilesContextFacade;

    public ExternalProfileServiceToUser(ProfilesContextFacade profilesContextFacade) {
        this.profilesContextFacade = profilesContextFacade;
    }

    public Optional<ProfileId> createProfile(byte[] imageProfile, String firstName, String email, String lastName){
        var profileId = profilesContextFacade.createProfile(imageProfile, firstName, email, lastName);
        if (profileId == 0L) return Optional.empty();
        return Optional.of(new ProfileId(profileId));
    }

}
