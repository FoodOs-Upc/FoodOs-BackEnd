package com.versoft.foodosbackend.Task.Application.Internal.CommandService;

import com.versoft.foodosbackend.Task.Domain.Model.Aggregates.Task;
import com.versoft.foodosbackend.Task.Domain.Model.Commands.CreateTaskCommand;
import com.versoft.foodosbackend.Task.Domain.Model.Commands.DeleteTaskCommand;
import com.versoft.foodosbackend.Task.Domain.Model.Commands.UpdateTaskCommand;
import com.versoft.foodosbackend.Task.Domain.Service.TaskCommandService;
import com.versoft.foodosbackend.Task.Infrastructure.Persistence.JPA.repositories.TaskRepository;


import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class TaskCommandServiceImpl implements TaskCommandService
{

    private final TaskRepository taskRepository;
    public TaskCommandServiceImpl(TaskRepository taskRepository) { this.taskRepository = taskRepository; }

    @Override
    public Long handle(CreateTaskCommand command)
    {
        if(taskRepository.existsByTitle(command.title()))
        {
            throw new IllegalArgumentException("Task already exists");
        }
        Task task = new Task(command);
        try
        {
            taskRepository.save(task);
        } catch(Exception e)
        {
            throw new IllegalArgumentException("Error while saving task" + e.getMessage());
        }
        return task.getId();
    }

    @Override
    public Optional<Task> handle (UpdateTaskCommand command)
    {
        if (taskRepository.existsByTitleAndIdIsNot(command.title(), command.id()))
            throw new IllegalArgumentException("Task with same title already exists");
        var result = taskRepository.findById(command.id());
        if(result.isEmpty()) throw new IllegalArgumentException("Task does not exist");
        var taskToUpdate = result.get();
        try
        {
            var updatedTask = taskRepository.save(taskToUpdate.updateTaskInformation(command.title(), command.description(), command.date(),command.memberasignado()));
            return Optional.of(updatedTask);
        } catch(Exception e)
        {
            throw new IllegalArgumentException("Error while saving task" + e.getMessage());
        }
    }

    @Override
    public void handle (DeleteTaskCommand command)
    {
        if (!taskRepository.existsById(command.id()))
        {
            throw new IllegalArgumentException("Task does not exist");
        }
        try
        {
            taskRepository.deleteById(command.id());
        } catch (Exception e)
        {
            throw new IllegalArgumentException("Error while deleting task" + e.getMessage());
        }
    }
}