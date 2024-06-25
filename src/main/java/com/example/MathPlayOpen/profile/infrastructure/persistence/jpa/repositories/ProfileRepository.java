package com.example.MathPlayOpen.profile.infrastructure.persistence.jpa.repositories;

import com.example.MathPlayOpen.profile.domain.model.aggregates.Profile;
import com.example.MathPlayOpen.profile.domain.model.valueobjects.EmailAddress;
import com.example.MathPlayOpen.profile.domain.model.valueobjects.ProfileId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
    Optional<Profile> findByEmail(EmailAddress emailAddress);
    boolean existsByEmail(EmailAddress emailAddress);
}
