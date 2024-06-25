package com.example.MathPlayOpen.performance.interfaces.rest.transform;

import com.example.MathPlayOpen.performance.domain.model.commands.CreateScoreCommand;
import com.example.MathPlayOpen.performance.interfaces.rest.resources.CreateScoreResource;

/**
 * @author Sharon Antuanet Ivet Barrial Marin - u202114900
 * @version 1.0
 */
public class CreateScoreCommandFromResourceAssembler {
    public static CreateScoreCommand toCommandFromResource(CreateScoreResource createScoreResource) {
        return new CreateScoreCommand(
                createScoreResource.participantId(),
                createScoreResource.amount()
        );
    }
}
