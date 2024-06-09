package com.example.MathPlayOpen.profile.interfaces.rest.transform;

import com.example.MathPlayOpen.profile.domain.model.commands.CreateProfileCommand;
import com.example.MathPlayOpen.profile.interfaces.rest.resources.CreateProfileResource;

public class CreateProfileCommandFromResourceAssembler {
    public static CreateProfileCommand toCommandFromResource(CreateProfileResource resource) {
        return new CreateProfileCommand(resource.firstName(), resource.lastName(), resource.email(), resource.password());
    }
}
