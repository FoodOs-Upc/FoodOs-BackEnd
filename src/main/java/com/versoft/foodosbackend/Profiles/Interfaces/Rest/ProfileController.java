package com.versoft.foodosbackend.Profiles.Interfaces.Rest;

import com.versoft.foodosbackend.Profiles.Domain.Model.Aggregates.Profile;
import com.versoft.foodosbackend.Profiles.Domain.Model.Commands.CreateProfileCommand;
import com.versoft.foodosbackend.Profiles.Domain.Model.Commands.DeleProductProfileCommand;
import com.versoft.foodosbackend.Profiles.Domain.Model.Commands.UpdateProfileCommand;
import com.versoft.foodosbackend.Profiles.Domain.Model.Queries.GetProfileByIdQuery;
import com.versoft.foodosbackend.Profiles.Domain.Services.ProfileCommandService;
import com.versoft.foodosbackend.Profiles.Domain.Services.ProfileQueryService;
import com.versoft.foodosbackend.Profiles.Interfaces.Rest.Resource.CreateProfileResource;
import com.versoft.foodosbackend.Profiles.Interfaces.Rest.Resource.ProfileResource;
import com.versoft.foodosbackend.Profiles.Interfaces.Rest.Resource.UpdateProfileResource;
import com.versoft.foodosbackend.Profiles.Interfaces.Rest.Transform.CreateProfileCommandFromResourceAssembler;
import com.versoft.foodosbackend.Profiles.Interfaces.Rest.Transform.ProfileResourceFromEntityAssembler;
import com.versoft.foodosbackend.Profiles.Interfaces.Rest.Transform.UpdateProfileCommandFromUpdateProfileResourceAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@RequestMapping(value = "/api/v1/profiles",produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Profile", description = "Profile Management Endpoints")

public class ProfileController {
    private final ProfileCommandService profileCommandService;
    private final ProfileQueryService profileQueryService;

    public ProfileController(ProfileCommandService profileCommandService, ProfileQueryService profileQueryService) {
        this.profileCommandService = profileCommandService;
        this.profileQueryService = profileQueryService;
    }

    @GetMapping("/{profileId}")
    public ResponseEntity<ProfileResource> getProfileById(@PathVariable("profileId") Long profileId) {
        var getProfileByIdQuery = new GetProfileByIdQuery(profileId);
        var profile = profileQueryService.handle(getProfileByIdQuery);

        if(profile.isEmpty()) return ResponseEntity.badRequest().build();

        var profileResource = ProfileResourceFromEntityAssembler.toResourceFromEntity(profile.get());
        return new ResponseEntity<>(profileResource, HttpStatus.CREATED);
    }

    @PostMapping(consumes = {"application/json"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProfileResource> createProfile(@ModelAttribute CreateProfileResource resource) throws IOException {

        var createProfileCommand = CreateProfileCommandFromResourceAssembler.toCommandFromResource(resource);
        var profileId = profileCommandService.handle(createProfileCommand);
        if (profileId==0L) return ResponseEntity.badRequest().build();

        var getProfileByIdQuery = new GetProfileByIdQuery(profileId);
        var profile = profileQueryService.handle(getProfileByIdQuery);
        if(profile.isEmpty()) return ResponseEntity.badRequest().build();
        var profileResource = ProfileResourceFromEntityAssembler.toResourceFromEntity(profile.get());
        return ResponseEntity.ok(profileResource);

    }

    @DeleteMapping("/{profileId}")
    public ResponseEntity<?> deleteProfile(@PathVariable("profileId") Long profileId) {
        var deleteProfileCommand = new DeleProductProfileCommand(profileId);
        this.profileCommandService.handle(deleteProfileCommand);
        return ResponseEntity.ok("Profile deleted successfully");

    }
    @PutMapping(value="/{profileId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProfileResource> updateProfile(@PathVariable Long profileId, @ModelAttribute UpdateProfileResource resource) throws IOException {
        var updateProfileCommand = UpdateProfileCommandFromUpdateProfileResourceAssembler.toCommandFromResource(profileId,resource);
        var updateProfile = profileCommandService.handle(updateProfileCommand);
        if(updateProfile.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        var profileResource = ProfileResourceFromEntityAssembler.toResourceFromEntity(updateProfile.get());
        return ResponseEntity.ok(profileResource);
    }
}
