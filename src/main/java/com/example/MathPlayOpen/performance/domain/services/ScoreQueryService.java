package com.example.MathPlayOpen.performance.domain.services;

import com.example.MathPlayOpen.performance.domain.model.aggregates.Score;
import com.example.MathPlayOpen.performance.domain.model.queries.GetScoreByIdQuery;

import java.util.Optional;

/**
 * @author Sharon Antuanet Ivet Barrial Marin - u202114900
 * @version 1.0
 */
public interface ScoreQueryService {
    Optional<Score> handle(GetScoreByIdQuery query);
}
