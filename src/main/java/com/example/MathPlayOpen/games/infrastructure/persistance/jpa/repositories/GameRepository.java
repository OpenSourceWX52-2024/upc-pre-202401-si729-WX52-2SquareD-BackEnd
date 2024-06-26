package com.example.MathPlayOpen.games.infrastructure.persistance.jpa.repositories;

import com.example.MathPlayOpen.games.domain.model.aggregates.Game;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    boolean existsByTitle(String title);
    boolean existsByTitleAndIdIsNot(String title, Long id);
}
