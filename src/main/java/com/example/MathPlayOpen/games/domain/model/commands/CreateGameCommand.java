package com.example.MathPlayOpen.games.domain.model.commands;

import com.example.MathPlayOpen.games.domain.model.valueobjects.Tags;

public record CreateGameCommand(
        String title,
        String description,
        String tagName
) {
    public CreateGameCommand {
        if (tagName == null || tagName.isBlank()) {
            throw new IllegalArgumentException("Tag name is required");
        }
        try {
            Tags.valueOf(tagName.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid tag name. Must be one of: " + java.util.Arrays.toString(Tags.values()));
        }
    }
}
