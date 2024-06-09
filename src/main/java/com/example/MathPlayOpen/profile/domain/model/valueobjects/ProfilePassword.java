package com.example.MathPlayOpen.profile.domain.model.valueobjects;

public record ProfilePassword(String content) {
    public ProfilePassword {
        if (content == null || content.isBlank()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }
    }

    public ProfilePassword() {
        this("");
    }
}
