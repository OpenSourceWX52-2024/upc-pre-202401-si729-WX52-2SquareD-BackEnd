package com.example.MathPlayOpen.user.domain.model.aggregates;


import com.example.MathPlayOpen.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import com.example.MathPlayOpen.user.domain.model.valueobjets.TeacherId;
import com.example.MathPlayOpen.user.domain.model.valueobjets.ProfileId;
import com.example.MathPlayOpen.user.domain.model.valueobjets.TeacherPerformanceMetricSet;
import jakarta.persistence.*;
import lombok.Getter;

/**
 * Representa un profesor.
 * El profesor es una raíz de agregado.
 */
@Entity
public class Teacher extends AuditableAbstractAggregateRoot<Teacher> {

    @Embedded
    @Column(name = "teacher_id")
    private final TeacherId teacherId;

    @Embedded
    private ProfileId profileId;

    @Embedded
    private TeacherPerformanceMetricSet performanceMetricSet;

    public Teacher() {
        this.teacherId = new TeacherId();
        this.performanceMetricSet = new TeacherPerformanceMetricSet();
    }

    public Teacher(Long profileId) {
        this();
        this.profileId = new ProfileId(profileId);
    }

    public Teacher(ProfileId profileId) {
        this();
        this.profileId = profileId;
    }

    /**
     * Actualiza las métricas del profesor cuando se completa un curso.
     * Incrementa el total de cursos completados.
     */
    public void updateMetricsOnCourseCompleted() {
        this.performanceMetricSet = this.performanceMetricSet.incrementTotalCompletedCourses();
    }

    /**
     * Actualiza las métricas del profesor cuando se completa un tutorial.
     * Incrementa el total de tutoriales completados.
     */
    public void updateMetricsOnTutorialCompleted() {
        this.performanceMetricSet = this.performanceMetricSet.incrementTotalTutorials();
    }

    public String getTeacherId() {
        return this.teacherId.teacherId();
    }

    public Long getProfileId() {
        return this.profileId.profileId();
    }

    public Integer getTotalCompletedCourses() {
        return this.performanceMetricSet.totalCompletedCourses();
    }

    public Integer getTotalTutorials() {
        return this.performanceMetricSet.totalTutorials();
    }

}
