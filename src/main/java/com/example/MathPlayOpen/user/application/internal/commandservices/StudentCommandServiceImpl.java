package com.example.MathPlayOpen.user.application.internal.commandservices;

import com.example.MathPlayOpen.user.application.internal.outboundservices.ExternalProfileService;
import com.example.MathPlayOpen.user.domain.model.aggregates.Student;
import com.example.MathPlayOpen.user.domain.model.commands.CreateStudentCommand;
import com.example.MathPlayOpen.user.domain.model.valueobjets.AcmeStudentRecordId;
import com.example.MathPlayOpen.user.domain.model.valueobjets.ProfileId;
import com.example.MathPlayOpen.user.domain.services.StudentCommandService;
import com.example.MathPlayOpen.user.infrastructure.persistence.jpa.StudentRepository;
import org.springframework.stereotype.Service;

/**
 * Implementación de StudentCommandService
 *
 * <p>
 *     Esta clase es la implementación de la interfaz StudentCommandService.
 *     Es utilizada por el contexto de usuario para manejar comandos en el agregado de Student.
 * </p>
 *
 */
    @Service
    public class StudentCommandServiceImpl implements StudentCommandService {
        private final StudentRepository studentRepository;
        private final ExternalProfileService externalProfileService;

        public StudentCommandServiceImpl(StudentRepository studentRepository, ExternalProfileService externalProfileService) {
            this.studentRepository = studentRepository;
            this.externalProfileService = externalProfileService;
        }

        //**
        // * Command handler to create student
        // *
        // * @param command containing student details
        // * @return AcmeStudentRecordId
        // */
        @Override
        public AcmeStudentRecordId handle(CreateStudentCommand command) {

            // Fetch profileId by email
            var profileId = externalProfileService.fetchProfileIdByEmail(command.email());

            // If profileId is empty, create profile
            if (profileId.isEmpty()) {
                profileId = externalProfileService.createProfile(command.firstName(), command.lastName(), command.email(), command.password());
            } else {
                // If profileId is not empty, check if student exists
                studentRepository.findByProfileId(profileId.get()).ifPresent(student -> {
                    throw new IllegalArgumentException("Student already exists");
                });
            }

            // If profileId is still empty, throw exception
            if (profileId.isEmpty()) throw new IllegalArgumentException("Unable to create profile");

            // Create student using fetched or created profileId
            var student = new Student(profileId.get());
            studentRepository.save(student);
            return student.getAcmeStudentRecordId();
        }

    }
