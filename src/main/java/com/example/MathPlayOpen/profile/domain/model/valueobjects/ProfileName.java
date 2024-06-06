package com.example.MathPlayOpen.profile.domain.model.valueobjects;

public record ProfileName(String firstName, String lastName) {
    public ProfileName {
        if (firstName == null || lastName == null) {
            throw new IllegalArgumentException("First name and last name must not be null");
        }
    }

    public ProfileName() {
        this("", "");
    }

    public String fullName() {
        return firstName + " " + lastName;
    }
}
