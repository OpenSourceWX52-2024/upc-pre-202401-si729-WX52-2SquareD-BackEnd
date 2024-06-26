package com.example.MathPlayOpen.user.infrastructure.persistence.jpa;


import com.example.MathPlayOpen.user.domain.model.aggregates.Teacher;
import com.example.MathPlayOpen.user.domain.model.valueobjets.ProfileId;
import com.example.MathPlayOpen.user.domain.model.valueobjets.TeacherId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    Optional<Teacher> findByTeacherId(TeacherId teacherRecordId);
    Optional<Teacher> findByProfileId(ProfileId profileId);
}
