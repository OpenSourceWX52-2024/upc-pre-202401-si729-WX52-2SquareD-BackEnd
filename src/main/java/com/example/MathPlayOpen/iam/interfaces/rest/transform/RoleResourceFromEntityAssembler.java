package com.example.MathPlayOpen.iam.interfaces.rest.transform;

import com.example.MathPlayOpen.iam.domain.model.entities.Role;
import com.example.MathPlayOpen.iam.interfaces.rest.resources.RoleResource;

public class RoleResourceFromEntityAssembler {
    public static RoleResource toResourceFromEntity(Role role) {
        return new RoleResource(role.getId(), role.getStringName());
    }
}
