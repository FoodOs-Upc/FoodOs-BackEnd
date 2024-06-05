package com.versoft.foodosbackend.Task.Interface.Rest.Transform;


import com.versoft.foodosbackend.Task.Domain.Model.Commands.CreateTaskCommand;
import com.versoft.foodosbackend.Task.Interface.Rest.Resource.CreateTaskResource;


public class CreateTaskCommandFromResourceAssembler
{
    public static CreateTaskCommand toCommandFromResource(CreateTaskResource resource)
    {

        return new CreateTaskCommand(resource.title(), resource.description(), resource.date(), resource.memberasignado());

    }
}
