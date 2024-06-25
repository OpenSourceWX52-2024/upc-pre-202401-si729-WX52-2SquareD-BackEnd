package com.example.MathPlayOpen.subscription.infrastructure.persistence.jpa.repositories;

import com.example.MathPlayOpen.profile.domain.model.valueobjects.ProfileId;
import com.example.MathPlayOpen.subscription.domain.models.aggregates.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

    boolean existsByUserIdAndPlanId(String userId, String planId);


    Optional<Subscription> findByUserIdAndPlanId(String userId, String planId);
}
