package com.versoft.foodosbackend.Task.Domain.Model.Commands;


public record UpdateTaskCommand (Long id,
                                 String title,
                                 String description,
                                 String date,
                                 String memberasignado) {
}
