package com.example.MathPlayOpen.performance.interfaces.rest.resources;

import jakarta.validation.constraints.NotNull;

/**
 * @author Sharon Antuanet Ivet Barrial Marin - u202114900
 * @version 1.0
 */
public record ScoreResource(
        Long participantId,
        Integer amount
) {
}
