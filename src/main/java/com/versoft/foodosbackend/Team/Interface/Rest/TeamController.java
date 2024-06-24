package com.versoft.foodosbackend.Team.Interface.Rest;


import com.versoft.foodosbackend.Team.Domain.Model.Commands.DeleteTeamMemberCommand;
import com.versoft.foodosbackend.Team.Domain.Model.Commands.UpdateTeamMemberCommand;
import com.versoft.foodosbackend.Team.Domain.Model.Queries.GetAllTeamMemberQuery;
import com.versoft.foodosbackend.Team.Domain.Model.Queries.GetTeamByIDQuery;
import com.versoft.foodosbackend.Team.Domain.Service.TeamCommandService;
import com.versoft.foodosbackend.Team.Domain.Service.TeamQueryService;
import com.versoft.foodosbackend.Team.Interface.Rest.Resource.CreateTeamMemberResource;
import com.versoft.foodosbackend.Team.Interface.Rest.Resource.TeamResource;
import com.versoft.foodosbackend.Team.Interface.Rest.Resource.UpdateTeamMemberResource;
import com.versoft.foodosbackend.Team.Interface.Rest.Transform.CreateTeamCommandFromResourceAssembler;
import com.versoft.foodosbackend.Team.Interface.Rest.Transform.TeamResourceFromEntityAssembler;
import com.versoft.foodosbackend.Team.Interface.Rest.Transform.UpdateTeamCommandFromResourceAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@RequestMapping(value = "/api/v1/team", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Team", description = "Team Management Endpoints")


public class TeamController
{
    private final TeamCommandService teamCommandService;
    private final TeamQueryService teamQueryService;

    public TeamController(TeamCommandService teamCommandService, TeamQueryService teamQueryService)
    {
        this.teamCommandService = teamCommandService;
        this.teamQueryService = teamQueryService;
    }

    @PostMapping
    public ResponseEntity<TeamResource> createTeam(@RequestBody CreateTeamMemberResource createTeamMemberResource)
    {
        var createTeamCommand = CreateTeamCommandFromResourceAssembler.toCommandFromResource(createTeamMemberResource);
        var team_id = teamCommandService.handle(createTeamCommand);
        if (team_id == 0L) {
            return ResponseEntity.badRequest().build();
        }
        var getCourseByIdQuery = new GetTeamByIDQuery(team_id);
        var team  = teamQueryService.handle(getCourseByIdQuery);
        if (team.isEmpty()) return ResponseEntity.badRequest().build();
        var teamResource = TeamResourceFromEntityAssembler.toResourceFromEntity(team.get());
        return new ResponseEntity<>(teamResource, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TeamResource>> getAllMembers()
    {
        var getAllTeamMemberQuery = new GetAllTeamMemberQuery();
        var team = teamQueryService.handle(getAllTeamMemberQuery);
        var teamResource = team.stream().map(TeamResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(teamResource);
    }

    @GetMapping("/{team_id}")
    public ResponseEntity<TeamResource> getTeamById(@PathVariable Long team_id)
    {
        var getTeamByIdQuery = new GetTeamByIDQuery(team_id);
        var teams = teamQueryService.handle(getTeamByIdQuery);
        if (teams.isEmpty()) return ResponseEntity.badRequest().build();
        var teamResources = TeamResourceFromEntityAssembler.toResourceFromEntity(teams.get());
        return ResponseEntity.ok(teamResources);
    }

    @PutMapping("/{team_id}")
    public ResponseEntity<TeamResource> updateTeam(@PathVariable Long team_id, @RequestBody UpdateTeamMemberResource updateTeamMemberResource)
    {
        var updateTeamCommand = UpdateTeamCommandFromResourceAssembler.toCommandFromResource(team_id, updateTeamMemberResource);
        var updateTeam = teamCommandService.handle(updateTeamCommand);
        if (updateTeam.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var teamResource = TeamResourceFromEntityAssembler.toResourceFromEntity(updateTeam.get());
        return ResponseEntity.ok(teamResource);
    }

    @DeleteMapping("/{team_id}")
    public ResponseEntity<?> deleteTeam(@PathVariable Long team_id)
    {
        var deleteTeamCommand = new DeleteTeamMemberCommand(team_id);
        teamCommandService.handle(deleteTeamCommand);
        return ResponseEntity.ok("Course with given id successfully deleted");
    }
}

