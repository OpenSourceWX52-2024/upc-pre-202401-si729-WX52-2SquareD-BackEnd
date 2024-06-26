package com.example.MathPlayOpen.user.application.internal.commandservices;

import com.example.MathPlayOpen.user.application.internal.outboundservices.ExternalProfileService;
import com.example.MathPlayOpen.user.domain.model.aggregates.Teacher;
import com.example.MathPlayOpen.user.domain.model.commands.CreateTeacherCommand;
import com.example.MathPlayOpen.user.domain.services.TeacherCommandService;
import com.example.MathPlayOpen.user.infrastructure.persistence.jpa.TeacherRepository;
import org.springframework.stereotype.Service;

/**
 * Implementación de TeacherCommandService
 *
 * <p>
 *     Esta clase es la implementación de la interfaz TeacherCommandService.
 *     Es utilizada por el contexto de usuario para manejar comandos en el agregado de Teacher.
 * </p>
 *
 */
@Service
public class TeacherCommandServiceImpl implements TeacherCommandService {
    private final TeacherRepository teacherRepository;
    private final ExternalProfileService externalProfileService;


    public TeacherCommandServiceImpl(TeacherRepository teacherRepository ,ExternalProfileService externalProfileService) {
        this.teacherRepository = teacherRepository;
        this.externalProfileService = externalProfileService;

    }

    /**
     * Manejador de comandos para crear un profesor
     *
     * @param command contiene los detalles del profesor
     * @return TeacherId
     */
    @Override
    public String handle(CreateTeacherCommand command) {
        // Fetch profileId by email
        var profileId = externalProfileService.fetchProfileIdByEmail(command.email());

        // If profileId is empty, create profile
        if (profileId.isEmpty()) {
            profileId = externalProfileService.createProfile(command.firstName(), command.lastName(), command.email(), command.passwordi());
        } else {
            // If profileId is not empty, check if teacher exists
            teacherRepository.findByProfileId(profileId.get()).ifPresent(teacher -> {
                throw new IllegalArgumentException("Teacher already exists");
            });
        }

        // If profileId is still empty, throw exception
        if (profileId.isEmpty()) throw new IllegalArgumentException("Unable to create profile");

        // Create teacher using fetched or created profileId
        var teacher = new Teacher(profileId.get());
        teacherRepository.save(teacher);
        return teacher.getTeacherId();
    }
}