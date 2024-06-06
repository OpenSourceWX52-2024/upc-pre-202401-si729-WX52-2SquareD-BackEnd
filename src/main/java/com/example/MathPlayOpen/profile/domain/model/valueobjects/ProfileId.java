package com.example.MathPlayOpen.profile.domain.model.valueobjects;

public record ProfileId(Long profileId) {
    public ProfileId {
        if (profileId < 0) {
            throw new IllegalArgumentException("ProfileId must not be null");
        }
    }

    public ProfileId(){
        this(0L);
    }
}
