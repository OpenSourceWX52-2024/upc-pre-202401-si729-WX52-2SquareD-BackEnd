package com.example.MathPlayOpen.games.interfaces;

import com.example.MathPlayOpen.games.domain.model.commands.DeleteGameCommand;
import com.example.MathPlayOpen.games.domain.model.queries.GetAllGamesQuery;
import com.example.MathPlayOpen.games.domain.model.queries.GetGameByIdQuery;
import com.example.MathPlayOpen.games.domain.services.GameCommandService;
import com.example.MathPlayOpen.games.domain.services.GameQueryService;
import com.example.MathPlayOpen.games.interfaces.rest.resources.CreateGameResource;
import com.example.MathPlayOpen.games.interfaces.rest.resources.GameResource;
import com.example.MathPlayOpen.games.interfaces.rest.resources.UpdateGameResource;
import com.example.MathPlayOpen.games.interfaces.rest.transform.CreateGameCommandFromResourceAssembler;
import com.example.MathPlayOpen.games.interfaces.rest.transform.GameResourceFromEntityAssembler;
import com.example.MathPlayOpen.games.interfaces.rest.transform.UpdateGameCommandFromResourceAssembler;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/games", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Games", description = "Game Management Endpoints")
public class GamesController {
    // Inject services
    private final GameCommandService gameCommandService;
    private final GameQueryService gameQueryService;
    // Constructor
    public GamesController(GameCommandService gameCommandService, GameQueryService gameQueryService) {
        this.gameCommandService = gameCommandService;
        this.gameQueryService = gameQueryService;
    }

    @PostMapping
    public ResponseEntity<GameResource> createGame(@RequestBody CreateGameResource createGameResource) {
        var createGameCommand = CreateGameCommandFromResourceAssembler.toCommandFromResource(createGameResource);
        var gameId = gameCommandService.handle(createGameCommand);
        if (gameId == 0L) {
            return ResponseEntity.badRequest().build();
        }
        var getGameByIdQuery = new GetGameByIdQuery(gameId);
        var gameEntity = gameQueryService.handle(getGameByIdQuery);
        if (gameEntity.isEmpty()) return ResponseEntity.badRequest().build();
        var gameResource = GameResourceFromEntityAssembler.toResourceFromEntity(gameEntity.get());
        return new ResponseEntity<>(gameResource, HttpStatus.CREATED);
    }
    @GetMapping("/{gameId}")
    public ResponseEntity<GameResource> getGameById(@PathVariable Long gameId){
        var getGameByIdQuery = new GetGameByIdQuery(gameId);
        var gameEntity = gameQueryService.handle(getGameByIdQuery);
        if (gameEntity.isEmpty()) return ResponseEntity.badRequest().build();
        var gameResource = GameResourceFromEntityAssembler.toResourceFromEntity(gameEntity.get());
        return ResponseEntity.ok(gameResource);
    }
    @GetMapping
    public ResponseEntity<List<GameResource>> getAllGames() {
        var getAllGamesQuery = new GetAllGamesQuery();
        var gameEntities = gameQueryService.handle(getAllGamesQuery);
        var gameResources = gameEntities.stream().map(GameResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(gameResources);
    }
    @PutMapping("/{gameId}")
    public ResponseEntity<GameResource> updateGame(@PathVariable Long gameId, @RequestBody UpdateGameResource updateGameResource) {
        var updateGameCommand = UpdateGameCommandFromResourceAssembler.toCommandFromResource(gameId, updateGameResource);
        var updatedGame = gameCommandService.handle(updateGameCommand);
        if (updatedGame.isEmpty()) return ResponseEntity.badRequest().build();
        var gameResource = GameResourceFromEntityAssembler.toResourceFromEntity(updatedGame.get());
        return ResponseEntity.ok(gameResource);
    }
    @DeleteMapping("/{gameId}")
    public ResponseEntity<?> deleteCourse(@PathVariable Long gameId) {
        var deleteGameCommand = new DeleteGameCommand(gameId);
        gameCommandService.handle(deleteGameCommand);
        return ResponseEntity.ok("Game with given id successfully deleted");
    }
}
