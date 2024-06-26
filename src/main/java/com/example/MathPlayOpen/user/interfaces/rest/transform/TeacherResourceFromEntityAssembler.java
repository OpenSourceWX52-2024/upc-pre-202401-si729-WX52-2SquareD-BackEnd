package com.example.MathPlayOpen.user.interfaces.rest.transform;

import com.example.MathPlayOpen.user.domain.model.aggregates.Teacher;
import com.example.MathPlayOpen.user.interfaces.rest.resources.TeacherResource;

public class TeacherResourceFromEntityAssembler {
    public static TeacherResource toResourceFromEntity(Teacher teacher) {
        return new TeacherResource(
                teacher.getTeacherId(),
                teacher.getProfileId()
        );
    }
}