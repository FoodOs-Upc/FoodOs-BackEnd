package com.versoft.foodosbackend.Team.Domain.Service;

import com.versoft.foodosbackend.Team.Domain.Model.Aggregates.Team;
import com.versoft.foodosbackend.Team.Domain.Model.Queries.GetAllTeamMemberQuery;
import com.versoft.foodosbackend.Team.Domain.Model.Queries.GetTeamByIDQuery;

import java.util.List;
import java.util.Optional;

public interface TeamQueryService {
    List<Team> handle(GetAllTeamMemberQuery query);
    Optional<Team> handle(GetTeamByIDQuery query);
}