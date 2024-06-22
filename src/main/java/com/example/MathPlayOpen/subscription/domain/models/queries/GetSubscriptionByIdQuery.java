package com.example.MathPlayOpen.subscription.domain.models.queries;

public record GetSubscriptionByIdQuery(Long id) {
    public GetSubscriptionByIdQuery {
        if (id == null) {
            throw new IllegalArgumentException("id cannot be null");
        }
    }
}
