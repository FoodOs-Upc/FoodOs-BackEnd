package com.versoft.foodosbackend.iam.domain.model.queries;


import com.versoft.foodosbackend.iam.domain.model.valueobjects.Roles;

public record GetRoleByNameQuery(Roles name) {
}