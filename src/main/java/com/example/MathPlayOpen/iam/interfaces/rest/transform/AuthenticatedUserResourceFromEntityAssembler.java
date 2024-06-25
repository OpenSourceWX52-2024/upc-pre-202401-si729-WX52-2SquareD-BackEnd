package com.example.MathPlayOpen.iam.interfaces.rest.transform;

import com.example.MathPlayOpen.iam.domain.model.aggregates.User;
import com.example.MathPlayOpen.iam.interfaces.rest.resources.AuthenticatedUserResource;

public class AuthenticatedUserResourceFromEntityAssembler {
    public static AuthenticatedUserResource toResourceFromEntity(User user, String token) {
        return new AuthenticatedUserResource(user.getId(), user.getEmail(), token);
    }
}

