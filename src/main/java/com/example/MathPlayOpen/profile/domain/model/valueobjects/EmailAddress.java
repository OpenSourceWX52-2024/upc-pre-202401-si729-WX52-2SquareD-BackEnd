package com.example.MathPlayOpen.profile.domain.model.valueobjects;

import jakarta.validation.constraints.Email;

public record EmailAddress(@Email String address) {
    public EmailAddress {
        if (address == null) {
            throw new IllegalArgumentException("Email must not be null");
        }
    }

    public EmailAddress() {
        this("");
    }
}
