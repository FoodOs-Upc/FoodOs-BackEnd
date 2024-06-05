package com.versoft.foodosbackend.Task.Infrastructure.Persistence.JPA.repositories;

import com.versoft.foodosbackend.Task.Domain.Model.Aggregates.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {
    Optional<Task> findByTitle(String title);
    Boolean existsByTitle(String title);
    Boolean existsByTitleAndIdIsNot(String title, Long id);
}
