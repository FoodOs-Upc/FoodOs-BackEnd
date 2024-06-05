package com.versoft.foodosbackend.Task.Interface.Rest;

import com.versoft.foodosbackend.Task.Domain.Model.Commands.DeleteTaskCommand;
import com.versoft.foodosbackend.Task.Domain.Model.Queries.GetAllTaskQuery;
import com.versoft.foodosbackend.Task.Domain.Model.Queries.GetTaskByIdQuery;
import com.versoft.foodosbackend.Task.Domain.Service.TaskCommandService;
import com.versoft.foodosbackend.Task.Domain.Service.TaskQueryService;
import com.versoft.foodosbackend.Task.Interface.Rest.Resource.CreateTaskResource;
import com.versoft.foodosbackend.Task.Interface.Rest.Resource.TaskResource;
import com.versoft.foodosbackend.Task.Interface.Rest.Resource.UpdateTaskResource;
import com.versoft.foodosbackend.Task.Interface.Rest.Transform.CreateTaskCommandFromResourceAssembler;
import com.versoft.foodosbackend.Task.Interface.Rest.Transform.TaskResourceFromEntityAssembler;
import com.versoft.foodosbackend.Task.Interface.Rest.Transform.UpdateTaskCommandFromResourceAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.*;


import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@RequestMapping(value = "/api/v1/task", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Task", description = "Task Management Endpoints")

public class TaskController {
    private final TaskCommandService taskCommandService;
    private final TaskQueryService taskQueryService;

    public TaskController(TaskCommandService taskCommandService, TaskQueryService taskQueryService) {
        this.taskCommandService = taskCommandService;
        this.taskQueryService = taskQueryService;
    }

    @PostMapping
    public ResponseEntity<TaskResource> createTask(@RequestBody CreateTaskResource createTaskResource) {
        var createTaskCommand = CreateTaskCommandFromResourceAssembler.toCommandFromResource(createTaskResource);
        var id = taskCommandService.handle(createTaskCommand);
        if (id == 0L) {
            return ResponseEntity.badRequest().build();
        }

        var getTaskByIdQuery = new GetTaskByIdQuery(id);
        var task = taskQueryService.handle(getTaskByIdQuery);
        if (task.isEmpty()) return ResponseEntity.badRequest().build();
        var taskResource = TaskResourceFromEntityAssembler.toResourceFromEntity(task.get());
        return new ResponseEntity<>(taskResource, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TaskResource>> getAllTask() {
        var getAllTaskQuery = new GetAllTaskQuery();
        var task = taskQueryService.handle(getAllTaskQuery);
        var taskResource = task.stream().map(TaskResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(taskResource);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResource> getTaskById(@PathVariable Long id) {
        var getTaskByIdQuery = new GetTaskByIdQuery(id);
        var task = taskQueryService.handle(getTaskByIdQuery);
        if (task.isEmpty()) return ResponseEntity.badRequest().build();
        var taskResource = TaskResourceFromEntityAssembler.toResourceFromEntity(task.get());
        return ResponseEntity.ok(taskResource);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskResource> updateTask(@PathVariable Long id, @RequestBody UpdateTaskResource updateTaskResource) {
        var updateTaskCommand = UpdateTaskCommandFromResourceAssembler.toCommandFromResource(id, updateTaskResource);
        var updateTask = taskCommandService.handle(updateTaskCommand);

        if (updateTask.isEmpty()) {
            return ResponseEntity.badRequest().build();

        }
        
        var taskResource = TaskResourceFromEntityAssembler.toResourceFromEntity(updateTask.get());
        return ResponseEntity.ok(taskResource);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long id) {
        var deleteTaskCommand = new DeleteTaskCommand(id);
        taskCommandService.handle(deleteTaskCommand);
        return ResponseEntity.ok("Task with given id successfully deleted.");
    }

}