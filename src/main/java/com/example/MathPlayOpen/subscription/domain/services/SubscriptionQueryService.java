package com.example.MathPlayOpen.subscription.domain.services;

import com.example.MathPlayOpen.subscription.domain.models.aggregates.Subscription;
import com.example.MathPlayOpen.subscription.domain.models.queries.*;

import java.util.List;
import java.util.Optional;

public interface SubscriptionQueryService {
    List<Subscription> handle(GetAllSubscriptionsQuery query);
    Optional<Subscription> handle(GetSubscriptionByIdQuery query);
    Optional<Subscription> handle(GetSubscriptionByUserIdAndPlanIdQuery query);
}