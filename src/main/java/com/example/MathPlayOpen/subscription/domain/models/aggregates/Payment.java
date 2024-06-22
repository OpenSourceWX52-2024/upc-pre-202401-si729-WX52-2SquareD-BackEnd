package com.example.MathPlayOpen.subscription.domain.models.aggregates;

import com.example.MathPlayOpen.subscription.domain.models.commands.CreatePaymentCommand;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Payment extends AbstractAggregateRoot<Payment> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Column(nullable = false)
    @Getter
    private String userId;

    @Column(nullable = false)
    @Getter
    private String paymentType;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Date paymentDate;

    @Getter
    @Column(nullable = false)
    private Double paymentAmount;

    @Getter
    @Column(nullable = false)
    private String paymentDescription;

    protected Payment() {
    }

    public Payment(CreatePaymentCommand command) {
        this.userId = command.userId();
        this.paymentType = command.paymentType();
        this.paymentDate = new Date();
        this.paymentAmount = Double.parseDouble(command.paymentAmount());
        this.paymentDescription = command.paymentDescription();
    }
}