package com.example.MathPlayOpen.games.domain.services;

import com.example.MathPlayOpen.games.domain.model.aggregates.Game;
import com.example.MathPlayOpen.games.domain.model.commands.CreateGameCommand;
import com.example.MathPlayOpen.games.domain.model.commands.DeleteGameCommand;
import com.example.MathPlayOpen.games.domain.model.commands.UpdateGameCommand;

import java.util.Optional;

public interface GameCommandService {
    Long handle(CreateGameCommand command);
    Optional<Game> handle(UpdateGameCommand command);
    void handle(DeleteGameCommand command);
}
