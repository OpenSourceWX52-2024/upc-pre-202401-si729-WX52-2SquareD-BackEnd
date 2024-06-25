package com.example.MathPlayOpen.subscription.domain.services;

import com.example.MathPlayOpen.subscription.domain.models.aggregates.Subscription;
import com.example.MathPlayOpen.subscription.domain.models.commands.CreateSubscriptionCommand;

import java.util.Optional;

public interface SubscriptionCommandService {
    Optional<Subscription> handle(CreateSubscriptionCommand command);
}
