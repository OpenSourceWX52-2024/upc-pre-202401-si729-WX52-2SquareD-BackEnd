package com.example.MathPlayOpen.profile.application.internal.queryservices;

import com.example.MathPlayOpen.profile.domain.model.aggregates.Profile;
import com.example.MathPlayOpen.profile.domain.model.queries.GetAllProfilesQuery;
import com.example.MathPlayOpen.profile.domain.model.queries.GetProfileByEmailQuery;
import com.example.MathPlayOpen.profile.domain.model.queries.GetProfileByIdQuery;
import com.example.MathPlayOpen.profile.domain.services.ProfileQueryService;
import com.example.MathPlayOpen.profile.infrastructure.persistence.jpa.repositories.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileQueryServiceImpl implements ProfileQueryService {
    private final ProfileRepository profileRepository;

    public ProfileQueryServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public Optional<Profile> handle(GetProfileByIdQuery query) {
        return profileRepository.findById(query.id());
    }

    @Override
    public Optional<Profile> handle(GetProfileByEmailQuery query) {
        return profileRepository.findByEmail(query.emailAddress());
    }

    @Override
    public List<Profile> handle(GetAllProfilesQuery query) {
        return profileRepository.findAll();
    }
}
