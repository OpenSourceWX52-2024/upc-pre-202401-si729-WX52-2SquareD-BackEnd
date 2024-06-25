package com.example.MathPlayOpen.performance.domain.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

/**
 * @author Sharon Antuanet Ivet Barrial Marin - u202114900
 * @version 1.0
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@With
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String name;

    /**
     * Constructor
     * This method creates a participant with a name
     * @param name Participant name
     */
    public Participant(String name) {
        this.name = name;
    }
}
