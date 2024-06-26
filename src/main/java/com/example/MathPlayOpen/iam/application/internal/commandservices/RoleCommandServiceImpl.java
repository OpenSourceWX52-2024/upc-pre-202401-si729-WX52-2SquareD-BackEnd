package com.example.MathPlayOpen.iam.application.internal.commandservices;

import com.example.MathPlayOpen.iam.domain.model.commands.SeedRolesCommand;
import com.example.MathPlayOpen.iam.domain.model.entities.Role;
import com.example.MathPlayOpen.iam.domain.model.valueobjects.Roles;
import com.example.MathPlayOpen.iam.domain.services.RoleCommandService;

import com.example.MathPlayOpen.iam.infrastructure.persistence.jpa.repositories.RoleRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class RoleCommandServiceImpl implements RoleCommandService {
    private final RoleRepository roleRepository;

    public RoleCommandServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    @Transactional
    public void handle(SeedRolesCommand command) {
        for (Roles role : Roles.values()) {
            if (!roleRepository.findByName(role).isPresent()) {
                roleRepository.save(new Role(role));
            }
        }
    }
}
