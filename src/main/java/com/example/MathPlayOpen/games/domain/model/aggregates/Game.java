package com.example.MathPlayOpen.games.domain.model.aggregates;

import com.example.MathPlayOpen.games.domain.model.commands.CreateGameCommand;
import com.example.MathPlayOpen.games.domain.model.commands.UpdateGameCommand;
import com.example.MathPlayOpen.games.domain.model.entities.Tag;
import com.example.MathPlayOpen.games.domain.model.valueobjects.Tags;
import com.example.MathPlayOpen.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
public class Game extends AuditableAbstractAggregateRoot<Game> {
    // Private Attributes
    @NotBlank (message = "Title is required")
    @Size(max = 100, message = "Title must be less than 100 characters")
    @Column(unique = true)
    private String title;
    @NotBlank (message = "Description is required")
    @Size(max = 500, message = "Description must be less than 500 characters")
    private String description;
    @Setter
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "tag_id", nullable = false)
    private Tag tag;
    // Constructors
    public Game() {}
    public Game(CreateGameCommand command) {
        this.title = command.title();
        this.description = command.description();
        this.tag = new Tag(Tags.valueOf(command.tagName().toUpperCase()));
    }
    // Public Methods
    public Game updateInformation(UpdateGameCommand command) {
        this.title = command.title();
        this.description = command.description();
        return this;
    }
}
