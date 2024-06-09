package com.example.MathPlayOpen.comunication.interfaces.rest;



import com.example.MathPlayOpen.comunication.domain.services.NotificationCommandService;
import com.example.MathPlayOpen.comunication.domain.services.NotificationQueryService;
import com.example.MathPlayOpen.comunication.interfaces.rest.resources.CreateNotificationResource;
import com.example.MathPlayOpen.comunication.interfaces.rest.resources.NotificationResource;
import com.example.MathPlayOpen.comunication.interfaces.rest.transform.CreateNotificationCommandFromResourceAssembler;
import com.example.MathPlayOpen.comunication.interfaces.rest.transform.NotificationResourceFromEntityAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/notificaciones")
public class NotificationController {
    private final NotificationCommandService notificationCommandService;
    private final NotificationQueryService notificationQueryService;

    public NotificationController(NotificationCommandService notificationCommandService, NotificationQueryService notificationQueryService) {
        this.notificationCommandService = notificationCommandService;
        this.notificationQueryService = notificationQueryService;
    }

    @PostMapping
    public ResponseEntity<NotificationResource> createNotification(@RequestBody CreateNotificationResource resource) {
        var command = CreateNotificationCommandFromResourceAssembler.toCommandFromResource(resource);
        var notification = notificationCommandService.handle(command).orElseThrow();
        var notificationResource = NotificationResourceFromEntityAssembler.toResourceFromEntity(notification);
        return ResponseEntity.ok(notificationResource);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotificationResource> getNotificationById(@PathVariable Long id) {
        var notification = notificationQueryService.getNotificationById(id).orElseThrow();
        var notificationResource = NotificationResourceFromEntityAssembler.toResourceFromEntity(notification);
        return ResponseEntity.ok(notificationResource);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<NotificationResource>> getNotificationsByUserId(@PathVariable Long userId) {
        var notifications = notificationQueryService.getNotificationsByUserId(userId);
        var notificationResources = notifications.stream()
                .map(NotificationResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(notificationResources);
    }
}
