package com.versoft.foodosbackend.iam.interfaces.rest.transform;


import com.versoft.foodosbackend.iam.domain.model.commands.SignInCommand;
import com.versoft.foodosbackend.iam.interfaces.rest.resources.SignInResource;

public class SignInCommandFromResourceAssembler {
    public static SignInCommand toCommandFromResource(SignInResource signInResource) {
        return new SignInCommand(signInResource.username(), signInResource.password());
    }
}