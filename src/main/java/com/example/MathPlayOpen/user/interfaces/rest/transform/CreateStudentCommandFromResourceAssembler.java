package com.example.MathPlayOpen.user.interfaces.rest.transform;

import com.example.MathPlayOpen.user.domain.model.commands.CreateStudentCommand;
import com.example.MathPlayOpen.user.interfaces.rest.resources.CreateStudentResource;

public class CreateStudentCommandFromResourceAssembler {
    public static CreateStudentCommand toCommandFromResource(CreateStudentResource resource) {
        return new CreateStudentCommand(
                resource.firstName(),
                resource.lastName(),
                resource.email(),
                resource.street()
        );
    }
}