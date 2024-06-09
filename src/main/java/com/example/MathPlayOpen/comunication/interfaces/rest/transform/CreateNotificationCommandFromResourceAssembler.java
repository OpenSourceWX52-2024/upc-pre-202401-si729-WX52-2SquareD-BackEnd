package com.example.MathPlayOpen.comunication.interfaces.rest.transform;


import com.example.MathPlayOpen.comunication.domain.models.commands.CreateNotificationCommand;
import com.example.MathPlayOpen.comunication.interfaces.rest.resources.CreateNotificationResource;

public class CreateNotificationCommandFromResourceAssembler {
    public static CreateNotificationCommand toCommandFromResource(CreateNotificationResource resource){
        return new CreateNotificationCommand(resource.userId(), resource.message());
    }
}