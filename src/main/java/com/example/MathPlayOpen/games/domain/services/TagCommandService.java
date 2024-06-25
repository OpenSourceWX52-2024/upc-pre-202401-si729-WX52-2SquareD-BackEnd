package com.example.MathPlayOpen.games.domain.services;

import com.example.MathPlayOpen.games.domain.model.commands.SeedTagsCommand;

public interface TagCommandService {
    void handle(SeedTagsCommand command);
}
