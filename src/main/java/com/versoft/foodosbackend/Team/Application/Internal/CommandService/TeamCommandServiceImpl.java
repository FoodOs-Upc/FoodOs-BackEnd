package com.versoft.foodosbackend.Team.Application.Internal.CommandService;

import com.versoft.foodosbackend.Team.Domain.Model.Aggregates.Team;
import com.versoft.foodosbackend.Team.Domain.Model.Commands.CreateTeamMemberCommand;
import com.versoft.foodosbackend.Team.Domain.Model.Commands.DeleteTeamMemberCommand;
import com.versoft.foodosbackend.Team.Domain.Model.Commands.UpdateTeamMemberCommand;
import com.versoft.foodosbackend.Team.Domain.Service.TeamCommandService;
import com.versoft.foodosbackend.Team.Infrastructure.Persistence.JPA.repositories.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeamCommandServiceImpl implements TeamCommandService {

    private final TeamRepository teamRepository;

    public TeamCommandServiceImpl(TeamRepository teamRepository) { this.teamRepository = teamRepository; }

    @Override
    public Long handle(CreateTeamMemberCommand command) {

        if (teamRepository.existsByName(command.Name())) {
            throw new IllegalArgumentException("Team with same Full Name already exists");
        }

        var team = new Team(command);
        try {
            teamRepository.save(team);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while saving Team" + e.getMessage());
        }
        return team.getTeamid();
    }

    @Override
    public Optional<Team> handle(UpdateTeamMemberCommand command) {
        if (teamRepository.existsByNameAndTeamidIsNot(command.Name(), command.team_id()))
            throw new IllegalArgumentException("Team with same Full Name already exists");
        var result =teamRepository.findById(command.team_id());
        if (result.isEmpty()) throw new IllegalArgumentException("Team does not exist");
        var TeamToUpdate = result.get();
        try {
            var UpdatedTeam = teamRepository.save(TeamToUpdate.updateTeamInformation(command.Name(), command.Profile_Picture(), command.Rol(), command.Description()));
            return Optional.of(UpdatedTeam);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while saving Team" + e.getMessage());
        }
    }

    @Override
    public void handle (DeleteTeamMemberCommand command) {
        if (!teamRepository.existsById(command.team_id())) {
            throw new IllegalArgumentException("Team does not exist");
        }
        try {
            teamRepository.deleteById(command.team_id());
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while deleting Team" + e.getMessage());
        }
    }
}
