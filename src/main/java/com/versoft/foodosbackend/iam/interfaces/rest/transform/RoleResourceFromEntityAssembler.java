package com.versoft.foodosbackend.iam.interfaces.rest.transform;


import com.versoft.foodosbackend.iam.domain.model.entities.Role;
import com.versoft.foodosbackend.iam.interfaces.rest.resources.RoleResource;

public class RoleResourceFromEntityAssembler {
    public static RoleResource toResourceFromEntity(Role role) {
        return new RoleResource(role.getId(), role.getStringName());
    }
}