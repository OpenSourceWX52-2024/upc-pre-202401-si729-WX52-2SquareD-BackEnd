package com.example.MathPlayOpen.games.interfaces.rest.resources;

public record GameResource(
        Long id,
        String title,
        String description,
        String tagName
) {
}
