package com.example.MathPlayOpen.performance.interfaces.rest.transform;

import com.example.MathPlayOpen.performance.domain.model.aggregates.Score;
import com.example.MathPlayOpen.performance.interfaces.rest.resources.ScoreResource;

/**
 * @author Sharon Antuanet Ivet Barrial Marin - u202114900
 * @version 1.0
 */
public class ScoreResourceFromEntityAssembler {
    public static ScoreResource toResourceFromEntity(Score score) {
        return new ScoreResource(
                score.getParticipant().getId(),
                score.getAmount()
        );
    }
}
