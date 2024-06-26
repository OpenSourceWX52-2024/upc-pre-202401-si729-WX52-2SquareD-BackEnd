package com.example.MathPlayOpen.user.interfaces.rest;

import com.example.MathPlayOpen.user.domain.model.valueobjets.AcmeStudentRecordId;
import com.example.MathPlayOpen.user.domain.services.StudentCommandService;
import com.example.MathPlayOpen.user.interfaces.rest.resources.CreateStudentResource;
import com.example.MathPlayOpen.user.interfaces.rest.resources.StudentResource;
import com.example.MathPlayOpen.user.interfaces.rest.transform.CreateStudentCommandFromResourceAssembler;
import com.example.MathPlayOpen.user.interfaces.rest.transform.StudentResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * StudentsController
 *
 * <p>Controlador que maneja los endpoints para los estudiantes.
 * Utiliza {@link StudentCommandService} para manejar los comandos relacionados con los estudiantes.
 * <ul>
 *     <li>POST /api/v1/students</li>
 *     <li>GET /api/v1/students/{acmeStudentRecordId}</li>
 * </ul>
 * </p>
 */
@RestController
@RequestMapping(value = "/api/v1/students", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Estudiantes", description = "Endpoints de Gestión de Estudiantes")
public class StudentsController {
    private final StudentCommandService studentCommandService;

    public StudentsController(StudentCommandService studentCommandService) {
        this.studentCommandService = studentCommandService;
    }

    /**
     * POST /api/v1/students
     *
     * <p>Endpoint para crear un estudiante</p>
     *
     * @param resource el recurso con la información para crear el estudiante
     * @return el estudiante creado
     * @see CreateStudentResource
     * @see StudentResource
     */
    @PostMapping
    public ResponseEntity<StudentResource> createStudent(@RequestBody CreateStudentResource resource) {
        var createStudentCommand = CreateStudentCommandFromResourceAssembler.toCommandFromResource(resource);
        var acmeStudentRecordId = studentCommandService.handle(createStudentCommand);
        if (acmeStudentRecordId.studentRecordId().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var studentResource = new StudentResource(acmeStudentRecordId.studentRecordId(), null, 0, 0); // Puedes llenar la información necesaria aquí si está disponible
        return new ResponseEntity<>(studentResource, HttpStatus.CREATED);
    }

    /**
     * GET /api/v1/students/{acmeStudentRecordId}
     *
     * <p>Endpoint para obtener un estudiante por su ID de Acme</p>
     *
     * @param acmeStudentRecordId el ID del estudiante en Acme
     * @return el recurso del estudiante
     * @see StudentResource
     */
    @GetMapping("/{acmeStudentRecordId}")
    public ResponseEntity<StudentResource> getStudentByAcmeStudentRecordId(@PathVariable String acmeStudentRecordId) {
        var studentResource = new StudentResource(acmeStudentRecordId, null, 0, 0); // Puedes llenar la información necesaria aquí si está disponible
        return ResponseEntity.ok(studentResource);
    }
}
