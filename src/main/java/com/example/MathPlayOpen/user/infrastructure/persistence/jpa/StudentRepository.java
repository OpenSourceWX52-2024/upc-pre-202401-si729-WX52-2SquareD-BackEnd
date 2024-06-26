package com.example.MathPlayOpen.user.infrastructure.persistence.jpa;

import com.example.MathPlayOpen.user.domain.model.aggregates.Student;
import com.example.MathPlayOpen.user.domain.model.valueobjets.AcmeStudentRecordId;
import com.example.MathPlayOpen.user.domain.model.valueobjets.ProfileId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByProfileId(ProfileId profileId);
}