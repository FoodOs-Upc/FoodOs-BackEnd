package com.versoft.foodosbackend.Profiles.Interfaces.acl;

import com.versoft.foodosbackend.Inventory.Domain.Service.ProductCommandService;
import com.versoft.foodosbackend.Profiles.Domain.Model.Commands.CreateProfileCommand;
import com.versoft.foodosbackend.Profiles.Domain.Model.Queries.GetProfileByEmailQuery;
import com.versoft.foodosbackend.Profiles.Domain.Model.ValueObjects.EmailAddress;
import com.versoft.foodosbackend.Profiles.Domain.Services.ProfileQueryService;
import org.springframework.stereotype.Service;

@Service
public class ProfilesContextFacade {
    private final ProfileQueryService profileQueryService;
    private final ProductCommandService profileCommandService;

    public ProfilesContextFacade(ProfileQueryService profileQueryService, ProductCommandService profileCommandService) {
        this.profileQueryService = profileQueryService;
        this.profileCommandService = profileCommandService;
    }
    public Long createProfile(byte[] imageProfile, String firstName,String email, String lastName) {
        var createProfileCommand = new CreateProfileCommand(imageProfile, firstName, email, lastName);
        return profileCommandService.handle(createProfileCommand);
    }

    public Long getProfileByEmail(String email) {
        var getProfileByEmailQuery = new GetProfileByEmailQuery(new EmailAddress(email));
        var profile = profileQueryService.handle(getProfileByEmailQuery);
        if (profile.isEmpty()) return 0L;
        return profile.get().getId();
    }

}
