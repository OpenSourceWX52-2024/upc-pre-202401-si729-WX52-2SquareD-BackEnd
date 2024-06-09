package com.example.MathPlayOpen.comunication.domain.models.commands;

public record CreateNotificationCommand(Long userId, String message) {
    public CreateNotificationCommand {
        if (userId == null) {
            throw new IllegalArgumentException("userId cannot be null");
        }
        if (message == null || message.isBlank()) {
            throw new IllegalArgumentException("message cannot be null or empty");
        }
    }
}