package com.example.MathPlayOpen.games.application.internal.commandservices;

import com.example.MathPlayOpen.games.domain.model.commands.SeedTagsCommand;
import com.example.MathPlayOpen.games.domain.model.entities.Tag;
import com.example.MathPlayOpen.games.domain.model.valueobjects.Tags;
import com.example.MathPlayOpen.games.domain.services.TagCommandService;
import com.example.MathPlayOpen.games.infrastructure.persistance.jpa.repositories.TagRepository;

import org.springframework.stereotype.Service;
import java.util.Arrays;

@Service
public class TagCommandServiceImpl implements TagCommandService{
    // Private Attribute
    private final TagRepository tagRepository;
    // Constructor
    public TagCommandServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }
    // Public Methods
    @Override
    public void handle(SeedTagsCommand command) {
        Arrays.stream(Tags.values()).forEach( tag -> {
                if(!tagRepository.existsByTag(tag)) {
                    tagRepository.save(new Tag(tag));
                }
        });
    }
}
