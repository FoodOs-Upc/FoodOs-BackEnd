package com.versoft.foodosbackend.Task.Interface.Rest.Resource;

public record CreateTaskResource (String title,
                                  String description,
                                  String date,
                                  String memberasignado) {
}