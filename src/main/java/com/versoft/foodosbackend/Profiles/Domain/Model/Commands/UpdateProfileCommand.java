package com.versoft.foodosbackend.Profiles.Domain.Model.Commands;

import org.springframework.web.multipart.MultipartFile;

public record UpdateProfileCommand(Long id,
                                   byte[] imageProfile,
                                   String email,
                                   String firstName,
                                   String lastName) {
}
