package com.example.MathPlayOpen.games.domain.model.commands;

public record UpdateGameCommand(Long gameId, String title, String description) {
    public UpdateGameCommand {
        if (title == null || title.isBlank() || title.length() > 100) {
            throw new IllegalArgumentException("Title is required and must be less than 100 characters");
        }
        if (description == null || description.isBlank() || description.length() > 500) {
            throw new IllegalArgumentException("Description is required and must be less than 500 characters");
        }
    }
}
