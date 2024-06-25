package com.example.MathPlayOpen.performance.infrastructure.persistance.jpa.repositories;

import com.example.MathPlayOpen.performance.domain.model.aggregates.Score;
import com.example.MathPlayOpen.performance.domain.model.valueobjects.Amount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Sharon Antuanet Ivet Barrial Marin - u202114900
 * @version 1.0
 */

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long> {
    boolean existsByParticipantIdAndAmount(Long participantId, Amount amount);
}
