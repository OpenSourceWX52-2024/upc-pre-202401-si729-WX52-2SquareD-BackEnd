package com.example.MathPlayOpen.iam.domain.model.commands;

import com.example.MathPlayOpen.iam.domain.model.entities.Role;

import java.util.List;

public record SignUpCommand(String username, String password, List<Role> roles) {
}