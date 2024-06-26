package com.example.MathPlayOpen.games.interfaces.rest.transform;

import com.example.MathPlayOpen.games.domain.model.commands.CreateGameCommand;
import com.example.MathPlayOpen.games.interfaces.rest.resources.CreateGameResource;

public class CreateGameCommandFromResourceAssembler {
    public static CreateGameCommand toCommandFromResource(CreateGameResource resource) {
        return new CreateGameCommand(
                resource.title(),
                resource.description(),
                resource.tagName()
        );
    }
}
