package com.versoft.foodosbackend.Task.Domain.Model.Commands;

public record CreateTaskCommand(String title,
                                String description,
                                String date,
                                String memberasignado) {
}
