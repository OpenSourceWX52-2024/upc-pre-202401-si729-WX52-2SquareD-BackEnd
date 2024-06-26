package com.example.MathPlayOpen.games.interfaces.rest.transform;

import com.example.MathPlayOpen.games.domain.model.commands.UpdateGameCommand;
import com.example.MathPlayOpen.games.interfaces.rest.resources.UpdateGameResource;

public class UpdateGameCommandFromResourceAssembler {
    public static UpdateGameCommand toCommandFromResource(Long courseId, UpdateGameResource resource) {
        return new UpdateGameCommand(
                courseId,
                resource.title(),
                resource.description()
        );
    }
}
