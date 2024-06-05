package com.versoft.foodosbackend.Task.Interface.Rest.Transform;

import com.versoft.foodosbackend.Task.Domain.Model.Aggregates.Task;
import com.versoft.foodosbackend.Task.Interface.Rest.Resource.TaskResource;

public class TaskResourceFromEntityAssembler {
    public static TaskResource toResourceFromEntity(Task entity) {
        return new TaskResource(entity.getId(), entity.getTitle(), entity.getDescription(), entity.getDate(), entity.getMemberasignado());
    }
}