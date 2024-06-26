package com.example.MathPlayOpen.games.infrastructure.persistance.jpa.repositories;

import com.example.MathPlayOpen.games.domain.model.entities.Tag;
import com.example.MathPlayOpen.games.domain.model.valueobjects.Tags;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface TagRepository extends JpaRepository<Tag, Long> {
    boolean existsByTag(Tags tag);
    Optional<Tag> findByTag(Tags tag);
}
