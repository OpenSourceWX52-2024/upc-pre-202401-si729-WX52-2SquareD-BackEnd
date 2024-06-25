package com.example.MathPlayOpen.games.domain.services;

import com.example.MathPlayOpen.games.domain.model.commands.SeedTagsCommand;

public interface TagsCommandService {
    void handle(SeedTagsCommand command);
}
