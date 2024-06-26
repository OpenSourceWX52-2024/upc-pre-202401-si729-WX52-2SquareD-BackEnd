package com.example.MathPlayOpen.performance.application.internal.commandservices;

import com.example.MathPlayOpen.performance.domain.model.aggregates.Score;
import com.example.MathPlayOpen.performance.domain.model.commands.CreateScoreCommand;
import com.example.MathPlayOpen.performance.domain.model.valueobjects.Amount;
import com.example.MathPlayOpen.performance.domain.services.ScoreCommandService;
import com.example.MathPlayOpen.performance.infrastructure.persistance.jpa.repositories.ScoreRepository;
import org.springframework.stereotype.Service;

/**
 * @author Sharon Antuanet Ivet Barrial Marin - u202114900
 * @version 1.0
 */

@Service
public class ScoreCommandServiceImpl implements ScoreCommandService {
    private final ScoreRepository scoreRepository;

    public ScoreCommandServiceImpl(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    @Override
    public Long handle(CreateScoreCommand createScoreCommand) {
        var participant = scoreRepository.findById(createScoreCommand.participantId());
        if (participant.isEmpty()) {
            throw new IllegalArgumentException("Participant not found");
        }

        Amount amount = new Amount(createScoreCommand.amount());

        if (scoreRepository.existsByParticipantIdAndAmount(participant.get().getId(), amount)) {
            throw new IllegalArgumentException("Score with participant and amount already exists");
        }

        var score = new Score(createScoreCommand);
        try {
            scoreRepository.save(score);
            return score.getId();
        } catch (Exception e) {
            throw new IllegalArgumentException("Error saving score" + e.getMessage());
        }

    }

}
