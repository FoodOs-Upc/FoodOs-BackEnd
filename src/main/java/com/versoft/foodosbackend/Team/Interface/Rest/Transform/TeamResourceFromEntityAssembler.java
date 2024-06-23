package com.versoft.foodosbackend.Team.Interface.Rest.Transform;

import com.versoft.foodosbackend.Team.Domain.Model.Aggregates.Team;
import com.versoft.foodosbackend.Team.Interface.Rest.Resource.TeamResource;

public class TeamResourceFromEntityAssembler {
    public static TeamResource toResourceFromEntity(Team entity) {
        return new TeamResource(entity.getId(), entity.getName(), entity.getProfilePicture(), entity.getRol(), entity.getDescription());
    }
}