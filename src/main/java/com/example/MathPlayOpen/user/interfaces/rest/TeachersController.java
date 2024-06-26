package com.example.MathPlayOpen.user.interfaces.rest;

import com.example.MathPlayOpen.user.domain.model.valueobjets.TeacherId;
import com.example.MathPlayOpen.user.domain.services.TeacherCommandService;
import com.example.MathPlayOpen.user.interfaces.rest.resources.CreateTeacherResource;
import com.example.MathPlayOpen.user.interfaces.rest.resources.TeacherResource;
import com.example.MathPlayOpen.user.interfaces.rest.transform.CreateTeacherCommandFromResourceAssembler;
import com.example.MathPlayOpen.user.interfaces.rest.transform.TeacherResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * TeachersController
 *
 * <p>Controlador que maneja los endpoints para los profesores.
 * Utiliza {@link TeacherCommandService} para manejar los comandos relacionados con los profesores.
 * <ul>
 *     <li>POST /api/v1/teachers</li>
 *     <li>GET /api/v1/teachers/{teacherRecordId}</li>
 * </ul>
 * </p>
 */
@RestController
@RequestMapping(value = "/api/v1/teachers", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Profesores", description = "Endpoints de Gestión de Profesores")
public class TeachersController {
    private final TeacherCommandService teacherCommandService;

    public TeachersController(TeacherCommandService teacherCommandService) {
        this.teacherCommandService = teacherCommandService;
    }

    /**
     * POST /api/v1/teachers
     *
     * <p>Endpoint para crear un profesor</p>
     *
     * @param resource el recurso con la información para crear el profesor
     * @return el profesor creado
     * @see CreateTeacherResource
     * @see TeacherResource
     */
    /*
    @PostMapping
    public ResponseEntity<TeacherResource> createTeacher(@RequestBody CreateTeacherResource resource) {
        var createTeacherCommand = CreateTeacherCommandFromResourceAssembler.toCommandFromResource(resource);
        var teacherId = teacherCommandService.handle(createTeacherCommand);
        if (teacherId.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
       // var teacherResource = new TeacherResource(teacherId.teacherId(), null); // Puedes llenar la información necesaria aquí si está disponible
       // return new ResponseEntity<>(teacherResource, HttpStatus.CREATED);
    }
    */


    @GetMapping("/{teacherId}")
    public ResponseEntity<TeacherResource> getTeacherByTeacherId(@PathVariable String teacherId) {
        var teacherResource = new TeacherResource(teacherId, null); // Puedes llenar la información necesaria aquí si está disponible
        return ResponseEntity.ok(teacherResource);
    }
}
