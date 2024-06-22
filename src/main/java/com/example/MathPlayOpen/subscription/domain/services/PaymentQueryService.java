package com.example.MathPlayOpen.subscription.domain.services;

import com.example.MathPlayOpen.subscription.domain.models.aggregates.Payment;
import com.example.MathPlayOpen.subscription.domain.models.queries.GetAllPaymentsQuery;
import com.example.MathPlayOpen.subscription.domain.models.queries.GetPaymentByIdQuery;


import java.util.List;
import java.util.Optional;

public interface PaymentQueryService {
    List<Payment> handle (GetAllPaymentsQuery query);
    Optional<Payment> handle (GetPaymentByIdQuery query);


}
