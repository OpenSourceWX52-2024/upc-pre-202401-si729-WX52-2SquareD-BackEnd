package com.example.MathPlayOpen.games.interfaces.rest.transform;

import com.example.MathPlayOpen.games.domain.model.aggregates.Game;
import com.example.MathPlayOpen.games.interfaces.rest.resources.GameResource;

public class GameResourceFromEntityAssembler {
    public static GameResource toResourceFromEntity(Game entity){
        return new GameResource(
                entity.getId(),
                entity.getTitle(),
                entity.getDescription(),
                entity.getTag().toString()
        );
    }
}
