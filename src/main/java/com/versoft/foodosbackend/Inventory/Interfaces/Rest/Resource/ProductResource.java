package com.versoft.foodosbackend.Inventory.Interfaces.Rest.Resource;

import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

public record ProductResource(
        Long id,
        byte[] file,
        String name ,
        String state,
        Date expirationDate,
        Date productionDate ) {
}
