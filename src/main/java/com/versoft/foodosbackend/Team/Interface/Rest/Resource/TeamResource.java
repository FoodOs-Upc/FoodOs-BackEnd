package com.versoft.foodosbackend.Team.Interface.Rest.Resource;

public record TeamResource (Long team_id,
                            String Name,
                            String Profile_Picture,
                            String Rol,
                            String Description) {
}