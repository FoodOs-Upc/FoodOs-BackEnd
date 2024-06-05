package com.versoft.foodosbackend.Inventory.Application.Internal.Outboundservices.acl;

import com.versoft.foodosbackend.Inventory.Domain.Model.ValueObjects.ProfileId;
import com.versoft.foodosbackend.Profiles.Interfaces.acl.ProfilesContextFacade;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExternalProfileService {
    private final ProfilesContextFacade profilesContextFacade;

    public ExternalProfileService(ProfilesContextFacade profilesContextFacade) {
        this.profilesContextFacade = profilesContextFacade;
    }

    public Optional<ProfileId> fetchProfileIdByEmail(String email){
        var profileId = profilesContextFacade.getProfileByEmail(email);
        if (profileId == 0L) return Optional.empty();
        return Optional.of(new ProfileId(profileId));
    }

    public Optional<ProfileId> createProfile(byte[] imageProfile, String firstName,String email, String lastName){
        var profileId = profilesContextFacade.createProfile(imageProfile, firstName, email, lastName);
        if (profileId == 0L) return Optional.empty();
        return Optional.of(new ProfileId(profileId));
    }
}
