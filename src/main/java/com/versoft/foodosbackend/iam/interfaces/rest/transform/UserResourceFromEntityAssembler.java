package com.versoft.foodosbackend.iam.interfaces.rest.transform;


import com.versoft.foodosbackend.iam.domain.model.aggregates.User;
import com.versoft.foodosbackend.iam.domain.model.entities.Role;
import com.versoft.foodosbackend.iam.interfaces.rest.resources.UserResource;

public class UserResourceFromEntityAssembler {
    public static UserResource toResourceFromEntity(User user) {
        var role = user.getRole().getStringName();
        return new UserResource(user.getId(), user.getUsername(), role);

    }
}