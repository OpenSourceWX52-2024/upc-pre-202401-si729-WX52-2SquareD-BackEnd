package com.example.MathPlayOpen.user.interfaces.rest.transform;

import com.example.MathPlayOpen.user.domain.model.aggregates.Student;
import com.example.MathPlayOpen.user.interfaces.rest.resources.StudentResource;

public class StudentResourceFromEntityAssembler {
    public static StudentResource toResourceFromEntity(Student student) {
        return new StudentResource(
                student.getStudentRecordId(),
                student.getProfileId(),
                student.getTotalCompletedCourses(),
                student.getTotalTutorials()
        );
    }
}