package com.example.MathPlayOpen.profile.interfaces.rest.transform;

import com.example.MathPlayOpen.profile.domain.model.aggregates.Profile;
import com.example.MathPlayOpen.profile.interfaces.rest.resources.ProfileResource;

public class ProfileResourceFromEntityAssembler {
    public static ProfileResource toResourceFromEntity(Profile entity) {
        return new ProfileResource(entity.getId(), entity.getFullName(), entity.getEmailAddress(), entity.getPassword());
    }
}
