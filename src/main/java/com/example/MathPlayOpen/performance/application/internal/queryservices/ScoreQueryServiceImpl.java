package com.example.MathPlayOpen.performance.application.internal.queryservices;

import com.example.MathPlayOpen.performance.domain.model.aggregates.Score;
import com.example.MathPlayOpen.performance.domain.model.queries.GetScoreByIdQuery;
import com.example.MathPlayOpen.performance.domain.services.ScoreQueryService;
import com.example.MathPlayOpen.performance.infrastructure.persistance.jpa.repositories.ScoreRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Sharon Antuanet Ivet Barrial Marin - u202114900
 * @version 1.0
 */

@Service
public class ScoreQueryServiceImpl implements ScoreQueryService {

    private final ScoreRepository scoreRepository;

    public ScoreQueryServiceImpl(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    @Override
    public Optional<Score> handle(GetScoreByIdQuery query) {
        return this.scoreRepository.findById(query.scoreId());
    }
}
