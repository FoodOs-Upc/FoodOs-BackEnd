package com.versoft.foodosbackend.Team.Domain.Model.Commands;

public record CreateTeamMemberCommand(String Name,
                                      String Profile_Picture,
                                      String Rol,
                                      String Description) {
}
