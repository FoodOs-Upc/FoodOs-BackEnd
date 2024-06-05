package com.versoft.foodosbackend.Task.Application.Internal.QueryService;

import com.versoft.foodosbackend.Task.Domain.Model.Aggregates.Task;
import com.versoft.foodosbackend.Task.Domain.Model.Queries.GetAllTaskQuery;
import com.versoft.foodosbackend.Task.Domain.Model.Queries.GetTaskByIdQuery;
import com.versoft.foodosbackend.Task.Domain.Service.TaskQueryService;
import com.versoft.foodosbackend.Task.Infrastructure.Persistence.JPA.repositories.TaskRepository;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service

public class TaskQueryServiceImpl implements TaskQueryService
{

    private final TaskRepository taskRepository;

    public TaskQueryServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Optional<Task> handle(GetTaskByIdQuery query) {
        return taskRepository.findById(query.id());
    }

    @Override
    public List<Task> handle (GetAllTaskQuery query) {
        return taskRepository.findAll();
    }
}
