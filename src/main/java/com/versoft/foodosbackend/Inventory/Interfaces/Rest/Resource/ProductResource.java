package com.versoft.foodosbackend.Inventory.Interfaces.Rest.Resource;

import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

public record ProductResource(
        String photoString,
        String stateString,
        String dateString,
        Long id,
        String name) {
}
