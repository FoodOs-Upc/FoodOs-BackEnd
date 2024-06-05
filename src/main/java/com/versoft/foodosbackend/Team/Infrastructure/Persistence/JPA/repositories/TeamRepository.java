package com.versoft.foodosbackend.Team.Infrastructure.Persistence.JPA.repositories;


import com.versoft.foodosbackend.Team.Domain.Model.Aggregates.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;


@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
    Optional<Team> findByName(String Name);
    boolean existsByName(String Name);
    boolean existsByNameAndTeamidIsNot(String Name, Long teamId);


}
