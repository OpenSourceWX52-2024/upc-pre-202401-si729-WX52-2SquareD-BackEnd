package com.example.MathPlayOpen.games.application.internal.commandservices;

import com.example.MathPlayOpen.games.domain.model.aggregates.Game;
import com.example.MathPlayOpen.games.domain.model.commands.CreateGameCommand;
import com.example.MathPlayOpen.games.domain.model.commands.DeleteGameCommand;
import com.example.MathPlayOpen.games.domain.model.commands.UpdateGameCommand;
import com.example.MathPlayOpen.games.domain.services.GameCommandService;
import com.example.MathPlayOpen.games.infrastructure.persistance.jpa.repositories.GameRepository;

import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class GameCommandServiceImpl implements GameCommandService {
    // Private Attributes
    private final GameRepository gameRepository;
    // Constructor
    public GameCommandServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }
    // Public methods
    @Override
    public Long handle(CreateGameCommand command) {
        if(gameRepository.existsByTitle(command.title()))
        {
            throw new IllegalArgumentException("Game with title " + command.title() + " already exists");
        }
        var game = new Game(command);
        try {
            gameRepository.save(game);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while saving game: " + e.getMessage());
        }
        return game.getId();
    }
    @Override
    public Optional<Game> handle(UpdateGameCommand command) {
        if(gameRepository.existsByTitleAndIdIsNot(command.title(), command.gameId())){
            throw new IllegalArgumentException("Game with title " + command.title() + " already exists");
        }
        var result = gameRepository.findById(command.gameId());
        if(result.isEmpty()) throw new IllegalArgumentException("Game with id " + command.gameId() + " not found");
        var gameToUpdate = result.get();
        try {
            var updatedGame = gameRepository.save(gameToUpdate.updateInformation(command));
            return Optional.of(updatedGame);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while updating game: " + e.getMessage());
        }
    }
    @Override
    public void handle(DeleteGameCommand command) {
        if(!gameRepository.existsById(command.gameId())){
            throw new IllegalArgumentException("Game with id " + command.gameId() + " not found");
        }
        try {
            gameRepository.deleteById(command.gameId());
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while deleting game: " + e.getMessage());
        }
    }
}
