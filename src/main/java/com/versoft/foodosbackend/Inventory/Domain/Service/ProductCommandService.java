package com.versoft.foodosbackend.Inventory.Domain.Service;

import com.versoft.foodosbackend.Inventory.Domain.Model.Commands.UpdateProductStateCommand;
import com.versoft.foodosbackend.Profiles.Domain.Model.Commands.CreateProfileCommand;

public interface ProductCommandService {
    Long handles(UpdateProductStateCommand command);
}
