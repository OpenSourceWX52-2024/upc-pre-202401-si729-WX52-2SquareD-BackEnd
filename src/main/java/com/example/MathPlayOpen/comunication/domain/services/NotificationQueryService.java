package com.example.MathPlayOpen.comunication.domain.services;



import com.example.MathPlayOpen.comunication.domain.models.aggregates.Notification;

import java.util.List;
import java.util.Optional;

public interface NotificationQueryService {
    Optional<Notification> getNotificationById(Long id);
    List<Notification> getNotificationsByUserId(Long userId);
}
