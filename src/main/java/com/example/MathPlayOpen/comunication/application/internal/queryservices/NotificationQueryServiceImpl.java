package com.example.MathPlayOpen.comunication.application.internal.queryservices;



import com.example.MathPlayOpen.comunication.domain.models.aggregates.Notification;
import com.example.MathPlayOpen.comunication.domain.services.NotificationQueryService;
import com.example.MathPlayOpen.comunication.infrastructure.persistence.jpa.NotificationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationQueryServiceImpl implements NotificationQueryService {
    private final NotificationRepository notificationRepository;

    public NotificationQueryServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public Optional<Notification> getNotificationById(Long id) {
        return notificationRepository.findById(id);
    }

    @Override
    public List<Notification> getNotificationsByUserId(Long userId) {
        return notificationRepository.findByUserId(userId);
    }
}
