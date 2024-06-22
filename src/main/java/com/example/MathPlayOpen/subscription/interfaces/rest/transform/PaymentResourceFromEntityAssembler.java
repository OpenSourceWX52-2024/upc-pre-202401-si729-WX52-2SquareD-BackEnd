package com.example.MathPlayOpen.subscription.interfaces.rest.transform;

import com.example.MathPlayOpen.subscription.domain.models.aggregates.Payment;
import com.example.MathPlayOpen.subscription.interfaces.rest.resources.PaymentResource;

public class PaymentResourceFromEntityAssembler {

    public static PaymentResource toResourceFromEntity(Payment entity) {
        String paymentAmount = Double.toString(entity.getPaymentAmount());
        return new PaymentResource(entity.getId(), entity.getUserId(), entity.getPaymentType(), entity.getPaymentDate(), paymentAmount, entity.getPaymentDescription());
    }
}
