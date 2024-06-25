package com.example.MathPlayOpen.subscription.domain.services;

import com.example.MathPlayOpen.subscription.domain.models.aggregates.Payment;
import com.example.MathPlayOpen.subscription.domain.models.commands.CreatePaymentCommand;

import java.util.Optional;

public interface PaymentCommandService {
    Optional<Payment> handle (CreatePaymentCommand command);
}
