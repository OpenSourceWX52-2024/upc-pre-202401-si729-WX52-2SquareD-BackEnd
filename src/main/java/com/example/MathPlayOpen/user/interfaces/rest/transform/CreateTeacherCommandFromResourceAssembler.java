package com.example.MathPlayOpen.user.interfaces.rest.transform;

import com.example.MathPlayOpen.user.domain.model.commands.CreateTeacherCommand;
import com.example.MathPlayOpen.user.interfaces.rest.resources.CreateTeacherResource;

public class CreateTeacherCommandFromResourceAssembler {
    public static CreateTeacherCommand toCommandFromResource(CreateTeacherResource resource) {
        return new CreateTeacherCommand(
                resource.firstName(),
                resource.lastName(),
                resource.email(),
                resource.street()
        );
    }
}