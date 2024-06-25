package com.example.MathPlayOpen.performance.domain.model.commands;

/**
 * @author Sharon Antuanet Ivet Barrial Marin - u202114900
 * @version 1.0
 */
public record CreateScoreCommand(
        Long participantId,
        Integer amount
) {
}
