package com.example.MathPlayOpen.comunication.interfaces.rest.resources;

public record CreateNotificationResource(Long userId, String message) {
    public CreateNotificationResource {
        if (userId == null) {
            throw new IllegalArgumentException("userId cannot be null");
        }
        if (message == null || message.isBlank()) {
            throw new IllegalArgumentException("message cannot be null or empty");
        }
    }
}
