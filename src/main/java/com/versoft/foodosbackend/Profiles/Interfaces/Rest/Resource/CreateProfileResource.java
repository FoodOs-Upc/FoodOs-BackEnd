package com.versoft.foodosbackend.Profiles.Interfaces.Rest.Resource;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public record CreateProfileResource(

        String firstName,

        String LastName,

        MultipartFile imageProfile,

        String emailAddress) {
}
