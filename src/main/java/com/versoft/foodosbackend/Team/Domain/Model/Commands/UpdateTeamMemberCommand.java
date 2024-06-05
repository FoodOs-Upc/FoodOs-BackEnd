package com.versoft.foodosbackend.Team.Domain.Model.Commands;

public record UpdateTeamMemberCommand(Long team_id,
                                      String Name,
                                      String Profile_Picture,
                                      String Rol,
                                      String Description) {
}
