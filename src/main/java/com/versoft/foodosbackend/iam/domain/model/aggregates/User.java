package com.versoft.foodosbackend.iam.domain.model.aggregates;


import com.versoft.foodosbackend.Shared.Domain.Aggregates.AuditableAbstractAggregateRoot;
import com.versoft.foodosbackend.iam.domain.model.entities.Role;
import com.versoft.foodosbackend.iam.domain.model.valueobjects.ProfileId;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * User aggregate root
 * This class represents the aggregate root for the User entity.
 *
 * @see AuditableAbstractAggregateRoot
 */
@Getter
@Setter
@Entity
public class User extends AuditableAbstractAggregateRoot<User> {

    @NotBlank
    @Size(max = 50)
    @Column(unique = true)
    private String username;

    @NotBlank
    @Size(max = 120)
    private String password;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @Embedded
    private ProfileId profileId;

    public User() {
        this.role = new Role();
    }
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.role = new Role();
    }

    public User(String username, String password, Role roles, ProfileId profileId) {
        this(username, password);
        this.role = roles;
        this.profileId = profileId;
    }



}