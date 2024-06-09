package com.example.MathPlayOpen.comunication.domain.models.queries;

public record GetNotificationsByUserIdQuery(Long userId) {
    public GetNotificationsByUserIdQuery {
        if (userId == null) {
            throw new IllegalArgumentException("userId cannot be null");
        }
    }
}