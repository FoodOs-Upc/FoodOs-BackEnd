package com.versoft.foodosbackend.Team.Interface.Rest.Transform;


import com.versoft.foodosbackend.Team.Domain.Model.Commands.CreateTeamMemberCommand;
import com.versoft.foodosbackend.Team.Interface.Rest.Resource.CreateTeamMemberResource;


public class CreateTeamCommandFromResourceAssembler {
    public static CreateTeamMemberCommand toCommandFromResource(CreateTeamMemberResource resource) {
        return new CreateTeamMemberCommand(resource.Name(), resource.Profile_Picture(), resource.Description(), resource.Rol());
    }
}
