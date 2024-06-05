package com.versoft.foodosbackend.Team.Application.Internal.QueryService;

import com.versoft.foodosbackend.Team.Domain.Model.Aggregates.Team;
import com.versoft.foodosbackend.Team.Domain.Model.Queries.GetAllTeamMemberQuery;
import com.versoft.foodosbackend.Team.Domain.Model.Queries.GetTeamByIDQuery;
import com.versoft.foodosbackend.Team.Domain.Service.TeamQueryService;
import com.versoft.foodosbackend.Team.Infrastructure.Persistence.JPA.repositories.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamQueryServiceImpl implements TeamQueryService {

    private final TeamRepository teamRepository;

    public TeamQueryServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public Optional<Team> handle(GetTeamByIDQuery query) {
        return teamRepository.findById(query.team_id());
    }

    @Override
    public List<Team> handle(GetAllTeamMemberQuery query) {
        return teamRepository.findAll();
    }
}