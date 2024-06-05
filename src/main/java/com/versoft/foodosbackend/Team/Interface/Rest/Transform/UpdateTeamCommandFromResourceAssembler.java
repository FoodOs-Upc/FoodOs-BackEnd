package com.versoft.foodosbackend.Team.Interface.Rest.Transform;

import com.versoft.foodosbackend.Team.Domain.Model.Commands.UpdateTeamMemberCommand;
import com.versoft.foodosbackend.Team.Interface.Rest.Resource.UpdateTeamMemberResource;

public class UpdateTeamCommandFromResourceAssembler {
    public static UpdateTeamMemberCommand toCommandFromResource(Long team_id, UpdateTeamMemberResource resource) {
        return new UpdateTeamMemberCommand(team_id, resource.Name(), resource.Profile_Picture(), resource.Description(), resource.Rol());
    }
}