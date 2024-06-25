package com.example.MathPlayOpen.subscription.application.internal.commandservices;

import com.example.MathPlayOpen.subscription.domain.models.aggregates.Payment;
import com.example.MathPlayOpen.subscription.domain.models.commands.CreatePaymentCommand;
import com.example.MathPlayOpen.subscription.domain.services.PaymentCommandService;
import com.example.MathPlayOpen.subscription.infrastructure.persistence.jpa.repositories.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentCommandServiceImpl implements PaymentCommandService {
    private final PaymentRepository paymentRepository;

    public PaymentCommandServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Optional<Payment> handle(CreatePaymentCommand command) {
        var payment = new Payment(command);
        var createdPayment = paymentRepository.save(payment);
        return Optional.of(createdPayment);
    }
}