package com.versoft.foodosbackend.Team.Domain.Model.Aggregates;


import com.versoft.foodosbackend.Team.Domain.Model.Commands.CreateTeamMemberCommand;
import jakarta.persistence.*;
import lombok.Getter;
import org.apache.logging.log4j.util.Strings;


import org.springframework.data.domain.AbstractAggregateRoot;


@Entity
@Table(name = "Team")


public class Team extends AbstractAggregateRoot<Team> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    @Getter
    private Long teamid;


    @Getter
    private String name;


    @Getter
    private String profilePicture;


    @Getter
    private String rol;


    @Getter
    private String description;


    public Team()
    {
        this.name = Strings.EMPTY;
        this.profilePicture = Strings.EMPTY;
        this.rol = Strings.EMPTY;
        this.description = Strings.EMPTY;
    }
    public Team(String Name, String Profile_Picture, String Rol, String Description)
    {
        this.name = Name;
        this.profilePicture = Profile_Picture;
        this.rol = Rol;
        this.description = Description;
    }

    public Team (CreateTeamMemberCommand command)
    {
        this();
        this.name = command.name();
        this.profilePicture = command.profilePicture();
        this.rol = command.rol();
        this.description = command.description();
    }

    public Team updateTeamInformation(String Name, String Profile_Picture, String Rol, String Description)
    {
        this.name = Name;
        this.profilePicture = Profile_Picture;
        this.rol = Rol;
        this.description = Description;
        return this;
    }
}
