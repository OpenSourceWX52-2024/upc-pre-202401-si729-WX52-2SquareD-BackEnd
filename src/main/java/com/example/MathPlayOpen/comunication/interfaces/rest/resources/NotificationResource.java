package com.example.MathPlayOpen.comunication.interfaces.rest.resources;

import java.util.Date;

public record NotificationResource(Long id, Long userId, String message, Date createdAt, Date updatedAt, boolean read) {
}