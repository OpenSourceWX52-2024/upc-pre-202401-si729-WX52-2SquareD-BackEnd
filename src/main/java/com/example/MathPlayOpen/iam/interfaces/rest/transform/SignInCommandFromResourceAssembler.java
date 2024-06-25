package com.example.MathPlayOpen.iam.interfaces.rest.transform;

import com.example.MathPlayOpen.iam.domain.model.commands.SignInCommand;
import com.example.MathPlayOpen.iam.interfaces.rest.resources.SignInResource;

public class SignInCommandFromResourceAssembler {
    public static SignInCommand toCommandFromResource(SignInResource signInResource) {
        return new SignInCommand(signInResource.username(), signInResource.password());
    }
}
