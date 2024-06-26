package com.example.MathPlayOpen.games.domain.services;

import com.example.MathPlayOpen.games.domain.model.aggregates.Game;
import com.example.MathPlayOpen.games.domain.model.queries.GetAllGamesQuery;
import com.example.MathPlayOpen.games.domain.model.queries.GetGameByIdQuery;

import java.util.List;
import java.util.Optional;

public interface GameQueryService {
    List<Game> handle(GetAllGamesQuery query);
    Optional<Game> handle(GetGameByIdQuery query);
}
