package com.example.MathPlayOpen.profile.domain.services;

import com.example.MathPlayOpen.profile.domain.model.aggregates.Profile;
import com.example.MathPlayOpen.profile.domain.model.queries.GetAllProfilesQuery;
import com.example.MathPlayOpen.profile.domain.model.queries.GetProfileByEmailQuery;
import com.example.MathPlayOpen.profile.domain.model.queries.GetProfileByIdQuery;

import java.util.List;
import java.util.Optional;

public interface ProfileQueryService {
    Optional<Profile> handle(GetProfileByIdQuery query);
    Optional<Profile> handle(GetProfileByEmailQuery query);
    List<Profile> handle(GetAllProfilesQuery query);
}
