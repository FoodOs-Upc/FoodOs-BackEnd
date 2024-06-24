package com.versoft.foodosbackend.Task.Interface.Rest.Resource;


public record UpdateTaskResource (String title,
                                  String description,
                                  String date,
                                  String memberasignado) {
}
