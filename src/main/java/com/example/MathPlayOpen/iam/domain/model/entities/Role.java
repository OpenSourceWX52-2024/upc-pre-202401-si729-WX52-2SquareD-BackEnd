package com.example.MathPlayOpen.iam.domain.model.entities;

import com.example.MathPlayOpen.iam.domain.model.valueobjects.Roles;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Entity
public class Role {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Enumerated(EnumType.STRING)
    @Column(length = 20, unique = true, nullable = false)
    private Roles name;

    public Role() {}
    public Role(Roles name) {
        this.name = name;
    }

    public String getStringName() {
        return name.name();
    }

    public static Role getDefaultRole() {
        return new Role(Roles.ROLE_STUDENT);
    }

    public static Role toRoleFromName(String name) {
        try {
            return new Role(Roles.valueOf(name));
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Role not found");
        }
    }

    public static List<Role> validateRoleSet(List<Role> roles) {
        if (roles == null || roles.isEmpty()) {
            return List.of(getDefaultRole());
        }
        return roles;
    }
}
