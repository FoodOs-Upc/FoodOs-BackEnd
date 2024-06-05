package com.versoft.foodosbackend.Inventory.Interfaces.Rest.Resource;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

public record AddProductResource(
                                 MultipartFile file,
                                 String name,
                                 @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                 Date expirationDate,
                                 @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                 Date productionDate) {
}
