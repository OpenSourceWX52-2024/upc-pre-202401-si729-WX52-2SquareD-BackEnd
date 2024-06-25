package com.example.MathPlayOpen.performance.domain.model.valueobjects;

/**
 * Represents the amount of a score game
 * The amount must not be null or negative
 * @author Sharon Antuanet Ivet Barrial Marin - u202114900
 * @version 1.0
 */
public record Amount(Integer amount) {
    public Amount {
        if (amount == null || amount < 0) {
            throw new IllegalArgumentException("Amount must not be null or negative");
        }
    }
}
