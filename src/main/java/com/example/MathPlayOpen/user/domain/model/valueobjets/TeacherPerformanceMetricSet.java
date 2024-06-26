package com.example.MathPlayOpen.user.domain.model.valueobjets;

import jakarta.persistence.Embeddable;

@Embeddable
public record TeacherPerformanceMetricSet(Integer totalCompletedCourses, Integer totalTutorials) {
    public TeacherPerformanceMetricSet() {
        this(0, 0);
    }

    public TeacherPerformanceMetricSet {
        if (totalCompletedCourses < 0) {
            throw new IllegalArgumentException("Total completed courses cannot be negative");
        }
        if (totalTutorials < 0) {
            throw new IllegalArgumentException("Total tutorials cannot be negative");
        }
    }

    public TeacherPerformanceMetricSet incrementTotalCompletedCourses() {
        return new TeacherPerformanceMetricSet(totalCompletedCourses + 1, totalTutorials);
    }

    public TeacherPerformanceMetricSet incrementTotalTutorials() {
        return new TeacherPerformanceMetricSet(totalCompletedCourses, totalTutorials + 1);
    }
}