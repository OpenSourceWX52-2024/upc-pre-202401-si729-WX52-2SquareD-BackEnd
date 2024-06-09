package com.example.MathPlayOpen.comunication.domain.models.queries;


public record GetMessagesByReceiverIdQuery(Long receiverId) {
    public GetMessagesByReceiverIdQuery {
        if (receiverId == null) {
            throw new IllegalArgumentException("receiverId cannot be null");
        }
    }
}