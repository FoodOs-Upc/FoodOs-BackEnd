package com.versoft.foodosbackend.Team.Domain.Service;

import com.versoft.foodosbackend.Team.Domain.Model.Aggregates.Team;
import com.versoft.foodosbackend.Team.Domain.Model.Commands.CreateTeamMemberCommand;
import com.versoft.foodosbackend.Team.Domain.Model.Commands.DeleteTeamMemberCommand;
import com.versoft.foodosbackend.Team.Domain.Model.Commands.UpdateTeamMemberCommand;
import java.util.Optional;

public interface TeamCommandService {
    Long handle (CreateTeamMemberCommand command);
    Optional<Team>  handle(UpdateTeamMemberCommand command);
    void handle(DeleteTeamMemberCommand command);
}