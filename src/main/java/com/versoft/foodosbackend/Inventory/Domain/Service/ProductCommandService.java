package com.versoft.foodosbackend.Inventory.Domain.Service;

import com.versoft.foodosbackend.Profiles.Domain.Model.Commands.CreateProfileCommand;

public interface ProductCommandService {
    Long handle(CreateProfileCommand command);
}
