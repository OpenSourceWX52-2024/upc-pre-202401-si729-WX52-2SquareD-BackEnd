package com.example.MathPlayOpen.profile.domain.model.queries;

import com.example.MathPlayOpen.profile.domain.model.valueobjects.EmailAddress;

public record GetProfileByEmailQuery(EmailAddress emailAddress) {
}
