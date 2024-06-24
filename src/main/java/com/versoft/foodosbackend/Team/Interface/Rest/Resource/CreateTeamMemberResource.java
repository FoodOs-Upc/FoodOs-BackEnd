package com.versoft.foodosbackend.Team.Interface.Rest.Resource;


public record CreateTeamMemberResource(String Name,
                                       String Profile_Picture,
                                       String Rol,
                                       String Description) {
}
