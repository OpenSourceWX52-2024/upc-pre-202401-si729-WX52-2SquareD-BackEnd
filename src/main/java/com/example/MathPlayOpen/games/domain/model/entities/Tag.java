package com.example.MathPlayOpen.games.domain.model.entities;

import com.example.MathPlayOpen.games.domain.model.valueobjects.Tags;
import com.example.MathPlayOpen.shared.domain.model.entities.AuditableModel;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class Tag extends AuditableModel {
    // Private Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(length = 20, unique = true, nullable = false)
    private Tags tag;
    // Constructors
    public Tag() {}
    public Tag(Tags tag) {
        this.tag = tag;
    }
}
