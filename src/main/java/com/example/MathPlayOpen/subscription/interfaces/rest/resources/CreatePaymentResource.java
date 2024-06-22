package com.example.MathPlayOpen.subscription.interfaces.rest.resources;

public record CreatePaymentResource(String userId, Long subscriptionId, Double amount) {
}
