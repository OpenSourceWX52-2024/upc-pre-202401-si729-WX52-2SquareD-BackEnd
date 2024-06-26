package com.example.MathPlayOpen.games.domain.exceptions;

public class GameNotFoundException extends RuntimeException {
    public GameNotFoundException(Long gameId) {
        super("Game with id " + gameId + " not found");
    }
}
