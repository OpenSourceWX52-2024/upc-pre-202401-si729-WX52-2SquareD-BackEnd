package com.example.MathPlayOpen.comunication.domain.models.queries;

public record GetMessagesBetweenUsersQuery(Long senderId, Long receiverId) {
    public GetMessagesBetweenUsersQuery {
        if (senderId == null) {
            throw new IllegalArgumentException("senderId cannot be null");
        }
        if (receiverId == null) {
            throw new IllegalArgumentException("receiverId cannot be null");
        }
    }
}