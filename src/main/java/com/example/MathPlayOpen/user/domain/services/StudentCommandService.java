package com.example.MathPlayOpen.user.domain.services;


import com.example.MathPlayOpen.user.domain.model.commands.CreateStudentCommand;
import com.example.MathPlayOpen.user.domain.model.valueobjets.AcmeStudentRecordId;

public interface StudentCommandService {
    AcmeStudentRecordId handle(CreateStudentCommand command);
}
