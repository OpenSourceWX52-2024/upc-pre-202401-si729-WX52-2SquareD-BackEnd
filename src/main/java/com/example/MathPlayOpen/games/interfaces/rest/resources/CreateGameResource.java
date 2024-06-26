package com.example.MathPlayOpen.games.interfaces.rest.resources;

public record CreateGameResource(
        String title,
        String description,
        String tagName
) {
}
