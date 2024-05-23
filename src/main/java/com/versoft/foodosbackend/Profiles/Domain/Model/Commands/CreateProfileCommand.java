package com.versoft.foodosbackend.Profiles.Domain.Model.Commands;

public record CreateProfileCommand(byte[] imageProfile,
                                   String email,
                                   String firstName,
                                   String lastName) {
}
