package com.example.MathPlayOpen.subscription.interfaces.rest;

import com.example.MathPlayOpen.subscription.domain.models.aggregates.Payment;
import com.example.MathPlayOpen.subscription.domain.models.queries.GetAllPaymentsQuery;
import com.example.MathPlayOpen.subscription.domain.models.queries.GetPaymentByIdQuery;
import com.example.MathPlayOpen.subscription.domain.services.PaymentCommandService;
import com.example.MathPlayOpen.subscription.domain.services.PaymentQueryService;
import com.example.MathPlayOpen.subscription.interfaces.rest.resources.CreatePaymentResource;
import com.example.MathPlayOpen.subscription.interfaces.rest.resources.PaymentResource;
import com.example.MathPlayOpen.subscription.interfaces.rest.transform.CreatePaymentCommandFromResourceAssembler;
import com.example.MathPlayOpen.subscription.interfaces.rest.transform.PaymentResourceFromEntityAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {
    private final PaymentCommandService paymentCommandService;
    private final PaymentQueryService paymentQueryService;

    public PaymentController(PaymentCommandService paymentCommandService, PaymentQueryService paymentQueryService) {
        this.paymentCommandService = paymentCommandService;
        this.paymentQueryService = paymentQueryService;
    }

    @PostMapping
    public ResponseEntity<PaymentResource> createPayment(@RequestBody CreatePaymentResource resource) {
        Optional<Payment> payment = paymentCommandService.handle(CreatePaymentCommandFromResourceAssembler.toCommandFromResource(resource));
        return payment.map(pay -> new ResponseEntity<>(PaymentResourceFromEntityAssembler.toResourceFromEntity(pay), CREATED)).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping("{id}")
    public ResponseEntity<PaymentResource> getPaymentById(@PathVariable Long id) {
        Optional<Payment> payment = paymentQueryService.handle(new GetPaymentByIdQuery(id));
        return payment.map(pay -> ResponseEntity.ok(PaymentResourceFromEntityAssembler.toResourceFromEntity(pay))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<PaymentResource>> getAllPayments() {
        var getAllPaymentsQuery = new GetAllPaymentsQuery();
        var payments = paymentQueryService.handle(getAllPaymentsQuery);
        if (payments.isEmpty()) return ResponseEntity.notFound().build();
        var paymentResources = payments.stream().map(PaymentResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(paymentResources);
    }
}