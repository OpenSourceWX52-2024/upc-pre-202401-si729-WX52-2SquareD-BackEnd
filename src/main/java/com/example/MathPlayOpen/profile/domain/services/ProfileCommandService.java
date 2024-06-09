package com.example.MathPlayOpen.profile.domain.services;

import com.example.MathPlayOpen.profile.domain.model.aggregates.Profile;
import com.example.MathPlayOpen.profile.domain.model.commands.CreateProfileCommand;

import java.util.Optional;

public interface ProfileCommandService {
    Optional<Profile> handle(CreateProfileCommand command);
}
