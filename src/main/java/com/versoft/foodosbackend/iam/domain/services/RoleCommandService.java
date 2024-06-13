package com.versoft.foodosbackend.iam.domain.services;


import com.versoft.foodosbackend.iam.domain.model.commands.SeedRolesCommand;

public interface RoleCommandService {
    void handle(SeedRolesCommand command);
}