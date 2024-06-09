package com.example.MathPlayOpen.comunication.interfaces.rest.transform;


import com.example.MathPlayOpen.comunication.domain.models.aggregates.Notification;
import com.example.MathPlayOpen.comunication.interfaces.rest.resources.NotificationResource;

public class NotificationResourceFromEntityAssembler {
    public static NotificationResource toResourceFromEntity(Notification entity){
        return new NotificationResource(entity.getId(), entity.getUser().getId(), entity.getMessage(), entity.getCreatedAt(), entity.getUpdatedAt(), entity.isRead());
    }
}