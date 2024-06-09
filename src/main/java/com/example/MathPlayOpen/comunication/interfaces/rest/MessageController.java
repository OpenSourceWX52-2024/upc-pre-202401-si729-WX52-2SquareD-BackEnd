package com.example.MathPlayOpen.comunication.interfaces.rest;

import com.example.MathPlayOpen.comunication.application.internal.commandservices.MessageCommandServiceImpl;
import com.example.MathPlayOpen.comunication.application.internal.queryservices.MessageQueryServiceImpl;
import com.example.MathPlayOpen.comunication.interfaces.rest.resources.CreateMessageResource;
import com.example.MathPlayOpen.comunication.interfaces.rest.resources.MessageResource;
import com.example.MathPlayOpen.comunication.interfaces.rest.transform.CreateMessageCommandFromResourceAssembler;
import com.example.MathPlayOpen.comunication.interfaces.rest.transform.MessageResourceFromEntityAssembler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/mensajes")
public class MessageController {
    private static final Logger logger = LoggerFactory.getLogger(MessageController.class);

    private final MessageCommandServiceImpl commandService;
    private final MessageQueryServiceImpl queryService;

    public MessageController(MessageCommandServiceImpl commandService, MessageQueryServiceImpl queryService) {
        this.commandService = commandService;
        this.queryService = queryService;
    }

    @PostMapping
    public ResponseEntity<MessageResource> sendMessage(@RequestBody CreateMessageResource resource) {
        var command = CreateMessageCommandFromResourceAssembler.toCommandFromResource(resource);
        var createdMessage = commandService.handle(command);

        return createdMessage.map(message -> ResponseEntity.ok(MessageResourceFromEntityAssembler.toResourceFromEntity(message)))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MessageResource> getMessageById(@PathVariable Long id) {
        var message = queryService.getMessageById(id);

        return message.map(value -> ResponseEntity.ok(MessageResourceFromEntityAssembler.toResourceFromEntity(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/sender/{senderId}")
    public ResponseEntity<List<MessageResource>> getMessagesBySenderId(@PathVariable Long senderId) {
        var messages = queryService.getMessagesBySenderId(senderId);

        List<MessageResource> resources = messages.stream()
                .map(MessageResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());

        return ResponseEntity.ok(resources);
    }

    @GetMapping("/receiver/{receiverId}")
    public ResponseEntity<List<MessageResource>> getMessagesByReceiverId(@PathVariable Long receiverId) {
        var messages = queryService.getMessagesByReceiverId(receiverId);

        List<MessageResource> resources = messages.stream()
                .map(MessageResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());

        return ResponseEntity.ok(resources);
    }

    @GetMapping("/between/{senderId}/{receiverId}")
    public ResponseEntity<List<MessageResource>> getMessagesBetweenUsers(@PathVariable Long senderId, @PathVariable Long receiverId) {
        var messages = queryService.getMessagesBetweenUsers(senderId, receiverId);

        List<MessageResource> resources = messages.stream()
                .map(MessageResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());

        return ResponseEntity.ok(resources);
    }
}
