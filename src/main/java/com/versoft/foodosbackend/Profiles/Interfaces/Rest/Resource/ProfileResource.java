package com.versoft.foodosbackend.Profiles.Interfaces.Rest.Resource;

public record ProfileResource(
        Long id,
        byte[] imageProfile,
        String lastName,
        String firstName,
        String emailAddress) {
}
