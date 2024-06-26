
package com.example.MathPlayOpen.user.domain.model.valueobjets;

import jakarta.persistence.Embeddable;
import java.util.UUID;

@Embeddable
public record TeacherId(String teacherId) {
    public TeacherId() {
        this(UUID.randomUUID().toString());
    }

    public TeacherId {
        if (teacherId == null || teacherId.isBlank()) {
            throw new IllegalArgumentException("Teacher ID cannot be null or blank");
        }
    }
}
