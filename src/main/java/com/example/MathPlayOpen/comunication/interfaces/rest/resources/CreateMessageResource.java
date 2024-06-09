package com.example.MathPlayOpen.comunication.interfaces.rest.resources;

public record CreateMessageResource(Long senderId, Long receiverId, String content) {
    public CreateMessageResource {
        if (senderId == null) {
            throw new IllegalArgumentException("senderId cannot be null");
        }
        if (receiverId == null) {
            throw new IllegalArgumentException("receiverId cannot be null");
        }
        if (content == null || content.isBlank()) {
            throw new IllegalArgumentException("content cannot be null or empty");
        }
    }
}