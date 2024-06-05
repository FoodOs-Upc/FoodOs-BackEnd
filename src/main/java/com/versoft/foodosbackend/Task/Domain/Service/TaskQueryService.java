package com.versoft.foodosbackend.Task.Domain.Service;

import com.versoft.foodosbackend.Task.Domain.Model.Aggregates.Task;
import com.versoft.foodosbackend.Task.Domain.Model.Queries.GetAllTaskQuery;
import com.versoft.foodosbackend.Task.Domain.Model.Queries.GetTaskByIdQuery;

import java.util.List;
import java.util.Optional;

public interface TaskQueryService {
    List<Task> handle(GetAllTaskQuery query);
    Optional<Task> handle(GetTaskByIdQuery query);
}
