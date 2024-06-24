package com.versoft.foodosbackend.iam.interfaces.rest.resources;

public record AuthenticatedUserResource(
        Long id, String username, String token,Long profileId) {
}