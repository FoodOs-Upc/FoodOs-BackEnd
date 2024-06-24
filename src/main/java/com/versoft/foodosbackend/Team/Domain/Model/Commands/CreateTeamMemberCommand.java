package com.versoft.foodosbackend.Team.Domain.Model.Commands;


public record CreateTeamMemberCommand(String name,
                                      String profilePicture,
                                      String rol,
                                      String description) {
}
