package com.example.MathPlayOpen.subscription.interfaces.rest.resources;

public record PaymentResource(String userId, Long subscriptionId, Double amount, String status) {
}
