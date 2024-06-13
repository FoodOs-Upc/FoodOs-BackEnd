package com.versoft.foodosbackend.iam.interfaces.rest.resources;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public record SignUpResource(
        String username,
        String password,
        String role,

        String firstName,
        String LastName,
        MultipartFile imageProfile,
        String emailAddress) {
}