package com.example.MathPlayOpen.performance.interfaces.rest;

import com.example.MathPlayOpen.performance.domain.model.queries.GetScoreByIdQuery;
import com.example.MathPlayOpen.performance.domain.services.ScoreCommandService;
import com.example.MathPlayOpen.performance.domain.services.ScoreQueryService;
import com.example.MathPlayOpen.performance.interfaces.rest.resources.CreateScoreResource;
import com.example.MathPlayOpen.performance.interfaces.rest.resources.ScoreResource;
import com.example.MathPlayOpen.performance.interfaces.rest.transform.CreateScoreCommandFromResourceAssembler;
import com.example.MathPlayOpen.performance.interfaces.rest.transform.ScoreResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * @author Sharon Antuanet Ivet Barrial Marin - u202114900
 * @version 1.0
 */

@RestController
@RequestMapping(value="/api/v1/scores", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Scores", description = "Scores Management Endpoints")
public class ScoreController {
    private final ScoreCommandService scoreCommandService;
    private final ScoreQueryService scoreQueryService;

    public ScoreController(ScoreCommandService scoreCommandService, ScoreQueryService scoreQueryService) {
        this.scoreCommandService = scoreCommandService;
        this.scoreQueryService = scoreQueryService;
    }

    /**
     * POST method to create a new score
     * @param res
     * @return
     */

    @PostMapping
    public ResponseEntity<ScoreResource> createScore(@RequestBody CreateScoreResource res) {
        var createScoreCommand = CreateScoreCommandFromResourceAssembler.toCommandFromResource(res);
        var scoreId = scoreCommandService.handle(createScoreCommand);
        if (scoreId == 0L) {
            return ResponseEntity.badRequest().build();
        }
        var getScoreByIdQuery = new GetScoreByIdQuery(scoreId);
        var score = scoreQueryService.handle(getScoreByIdQuery);
        if (score.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var scoreResource = ScoreResourceFromEntityAssembler.toResourceFromEntity(score.get());
        return new ResponseEntity<>(scoreResource, HttpStatus.CREATED);
    }

    /**
     * GET method to get score by participant id
     * @param participantId
     * @return scoreResource
     */

    @GetMapping("/{participantId}")
    public ResponseEntity<ScoreResource> getScoreByParticipantId(@PathVariable Long participantId) {
        var getScoreByIdQuery = new GetScoreByIdQuery(participantId);
        var score = scoreQueryService.handle(getScoreByIdQuery);
        if (score.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var scoreResource = ScoreResourceFromEntityAssembler.toResourceFromEntity(score.get());
        return new ResponseEntity<>(scoreResource, HttpStatus.OK);
    }



}
