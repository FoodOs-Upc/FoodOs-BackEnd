package com.versoft.foodosbackend.Task.Interface.Rest.Resource;

public record TaskResource (Long id,
                            String title,
                            String description,
                            String date,
                            String memberasignado) {
}