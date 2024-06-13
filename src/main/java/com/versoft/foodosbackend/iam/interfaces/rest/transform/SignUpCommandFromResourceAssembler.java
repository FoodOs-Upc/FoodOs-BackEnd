package com.versoft.foodosbackend.iam.interfaces.rest.transform;



import com.versoft.foodosbackend.iam.domain.model.commands.SignUpCommand;
import com.versoft.foodosbackend.iam.domain.model.entities.Role;
import com.versoft.foodosbackend.iam.interfaces.rest.resources.SignUpResource;

import java.io.IOException;
import java.util.ArrayList;

public class SignUpCommandFromResourceAssembler {
    public static SignUpCommand toCommandFromResource(SignUpResource resource) throws IOException {
        var role = resource.role() != null ? Role.toRoleFromName(resource.role()) : new Role();
        return new SignUpCommand(
                resource.username(),
                resource.password(),
                role,resource.imageProfile().getBytes(),
                resource.emailAddress(),
                resource.firstName(),
                resource.LastName());
    }
}