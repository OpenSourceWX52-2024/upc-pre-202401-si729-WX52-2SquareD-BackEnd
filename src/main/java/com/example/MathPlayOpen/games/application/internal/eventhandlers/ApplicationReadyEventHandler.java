package com.example.MathPlayOpen.games.application.internal.eventhandlers;

import com.example.MathPlayOpen.games.domain.model.commands.SeedTagsCommand;
import com.example.MathPlayOpen.games.domain.services.TagCommandService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;

@Service
public class ApplicationReadyEventHandler {
    // Private Attributes
    private final TagCommandService tagCommandService;
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationReadyEventHandler.class);
    // Constructor
    public ApplicationReadyEventHandler(TagCommandService tagCommandService) {
        this.tagCommandService = tagCommandService;
    }
    // Methods
    @EventListener
    public void on(ApplicationReadyEvent event){
        var applicationName = event.getApplicationContext().getId();
        LOGGER.info("Starting to verify if tags seeding is needed for {} at {}", applicationName, currentTimestamp());
        var seedTagsCommand = new SeedTagsCommand();
        tagCommandService.handle(seedTagsCommand);
        LOGGER.info("Finished verifying if tags seeding is needed for {} at {}", applicationName, currentTimestamp());
    }
    private Timestamp currentTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }
}
