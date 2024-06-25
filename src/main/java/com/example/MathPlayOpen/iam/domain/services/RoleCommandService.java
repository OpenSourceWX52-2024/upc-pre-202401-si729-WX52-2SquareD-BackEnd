package com.example.MathPlayOpen.iam.domain.services;

import com.example.MathPlayOpen.iam.domain.model.commands.SeedRolesCommand;

public interface RoleCommandService {
    void handle(SeedRolesCommand command);
}