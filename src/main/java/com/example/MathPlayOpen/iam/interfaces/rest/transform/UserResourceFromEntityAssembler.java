package com.example.MathPlayOpen.iam.interfaces.rest.transform;

import com.example.MathPlayOpen.iam.domain.model.aggregates.User;
import com.example.MathPlayOpen.iam.domain.model.entities.Role;
import com.example.MathPlayOpen.iam.interfaces.rest.resources.UserResource;

public class UserResourceFromEntityAssembler {
    public static UserResource toResourceFromEntity(User user) {
        var roles = user.getRoles().stream().map(Role::getStringName).toList();
        return new UserResource(user.getId(), user.getEmail(), roles);
    }
}
