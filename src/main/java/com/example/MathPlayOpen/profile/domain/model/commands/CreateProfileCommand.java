package com.example.MathPlayOpen.profile.domain.model.commands;

public record CreateProfileCommand(String firstName, String lastName, String email, String password) {
}
