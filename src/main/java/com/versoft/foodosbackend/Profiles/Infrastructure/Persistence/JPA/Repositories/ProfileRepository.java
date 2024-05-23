package com.versoft.foodosbackend.Profiles.Infrastructure.Persistence.JPA.Repositories;

import com.versoft.foodosbackend.Profiles.Domain.Model.Aggregates.Profile;
import com.versoft.foodosbackend.Profiles.Domain.Model.ValueObjects.EmailAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<Profile,Long> {
    Optional<Profile> findProfileByEmailAddress(EmailAddress emailAddress);
    boolean existsByEmailAddress(EmailAddress emailAddress);

}
