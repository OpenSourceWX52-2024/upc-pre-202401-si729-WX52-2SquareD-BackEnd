package com.example.MathPlayOpen.comunication.application.internal.commandservices;


import com.example.MathPlayOpen.comunication.domain.models.aggregates.Notification;
import com.example.MathPlayOpen.comunication.domain.models.aggregates.User;
import com.example.MathPlayOpen.comunication.domain.models.commands.CreateNotificationCommand;
import com.example.MathPlayOpen.comunication.domain.services.NotificationCommandService;
import com.example.MathPlayOpen.comunication.infrastructure.persistence.jpa.NotificationRepository;
import com.example.MathPlayOpen.comunication.infrastructure.persistence.jpa.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NotificationCommandServiceImpl implements NotificationCommandService {
    private final NotificationRepository notificationRepository;
    private final UserRepository userRepository;

    public NotificationCommandServiceImpl(NotificationRepository notificationRepository, UserRepository userRepository) {
        this.notificationRepository = notificationRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Optional<Notification> handle(CreateNotificationCommand command) {
        User user = userRepository.findById(command.userId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid userId"));
        Notification notification = new Notification(command, user);
        Notification createdNotification = notificationRepository.save(notification);
        return Optional.of(createdNotification);
    }
}