package com.example.MathPlayOpen.games.application.internal.queryservices;

import com.example.MathPlayOpen.games.domain.model.aggregates.Game;
import com.example.MathPlayOpen.games.domain.model.queries.GetAllGamesQuery;
import com.example.MathPlayOpen.games.domain.model.queries.GetGameByIdQuery;
import com.example.MathPlayOpen.games.domain.services.GameQueryService;

import com.example.MathPlayOpen.games.infrastructure.persistance.jpa.repositories.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameQueryServiceImpl implements GameQueryService {
    // Private Attributes
    private final GameRepository gameRepository;
    // Constructor
    public GameQueryServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }
    // Public methods
    @Override
    public List<Game> handle(GetAllGamesQuery query) {
        return gameRepository.findAll();
    }
    @Override
    public Optional<Game> handle(GetGameByIdQuery query) {
        return gameRepository.findById(query.gameId());
    }
}
