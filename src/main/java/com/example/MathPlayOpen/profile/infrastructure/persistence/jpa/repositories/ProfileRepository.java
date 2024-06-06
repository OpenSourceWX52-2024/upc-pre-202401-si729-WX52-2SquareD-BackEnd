package com.example.MathPlayOpen.profile.infrastructure.persistence.jpa.repositories;

import com.example.MathPlayOpen.profile.domain.model.aggregates.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
    //Profile findByUsername(String username);
    //Profile findByEmail(String email);
    //Profile findByUsernameOrEmail(String username, String email);
    //List<Profile> findByIdIn(List<Long> userIds);
    //Boolean existsByUsername(String username);
    //Boolean existsByEmail(String email);
}
