package com.example.MathPlayOpen.iam.domain.services;

import com.example.MathPlayOpen.iam.domain.model.commands.SeedRolesCommand;
import org.springframework.stereotype.Service;

@Service
public interface RoleCommandService {
    void handle(SeedRolesCommand command);
}
