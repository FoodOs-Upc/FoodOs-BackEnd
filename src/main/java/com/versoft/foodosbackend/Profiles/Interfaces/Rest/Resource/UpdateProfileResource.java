package com.versoft.foodosbackend.Profiles.Interfaces.Rest.Resource;

import org.springframework.web.multipart.MultipartFile;

public record UpdateProfileResource(MultipartFile imageProfile,
                                    String email,
                                    String firstName,
                                    String lastName) {
}
