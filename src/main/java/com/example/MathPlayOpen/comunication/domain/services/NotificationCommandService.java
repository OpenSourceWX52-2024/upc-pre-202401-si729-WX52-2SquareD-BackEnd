package com.example.MathPlayOpen.comunication.domain.services;


import com.example.MathPlayOpen.comunication.domain.models.aggregates.Notification;
import com.example.MathPlayOpen.comunication.domain.models.commands.CreateNotificationCommand;

import java.util.Optional;

public interface NotificationCommandService {
    Optional<Notification> handle(CreateNotificationCommand command);
}
