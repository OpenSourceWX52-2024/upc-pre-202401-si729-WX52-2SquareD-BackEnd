package com.example.MathPlayOpen.comunication.infrastructure.persistence.jpa;

import com.example.MathPlayOpen.comunication.domain.models.aggregates.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}