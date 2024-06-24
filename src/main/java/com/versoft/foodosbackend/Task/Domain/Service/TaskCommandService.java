package com.versoft.foodosbackend.Task.Domain.Service;


import com.versoft.foodosbackend.Task.Domain.Model.Aggregates.Task;
import com.versoft.foodosbackend.Task.Domain.Model.Commands.CreateTaskCommand;
import com.versoft.foodosbackend.Task.Domain.Model.Commands.DeleteTaskCommand;
import com.versoft.foodosbackend.Task.Domain.Model.Commands.UpdateTaskCommand;


import java.util.Optional;


public interface TaskCommandService
{
    Long handle (CreateTaskCommand command);
    Optional<Task> handle (UpdateTaskCommand command);
    void handle (DeleteTaskCommand command);
}
