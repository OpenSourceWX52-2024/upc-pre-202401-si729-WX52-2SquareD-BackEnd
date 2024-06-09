package com.example.MathPlayOpen.comunication.interfaces.rest.resources;

import java.util.Date;

public record MessageResource(Long id, Long senderId, Long receiverId, String content, Date createdAt, Date updatedAt) {
}