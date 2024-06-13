package com.versoft.foodosbackend.iam.domain.model.commands;



import com.versoft.foodosbackend.iam.domain.model.entities.Role;

import java.util.List;

public record SignUpCommand(
        String username,
        String password,
        Role role,

        byte[] imageProfile,
        String email,
        String firstName,
        String lastName) {
}
