package com.example.MathPlayOpen.user.domain.services;

import com.example.MathPlayOpen.user.domain.model.commands.CreateTeacherCommand;

public interface TeacherCommandService {
    String handle(CreateTeacherCommand command);
}
