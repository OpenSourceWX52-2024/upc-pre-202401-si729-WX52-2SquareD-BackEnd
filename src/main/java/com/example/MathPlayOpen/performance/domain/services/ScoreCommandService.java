package com.example.MathPlayOpen.performance.domain.services;

import com.example.MathPlayOpen.performance.domain.model.commands.CreateScoreCommand;

/**
 * @author Sharon Antuanet Ivet Barrial Marin - u202114900
 * @version 1.0
 */
public interface ScoreCommandService {
    Long handle(CreateScoreCommand command);
}
