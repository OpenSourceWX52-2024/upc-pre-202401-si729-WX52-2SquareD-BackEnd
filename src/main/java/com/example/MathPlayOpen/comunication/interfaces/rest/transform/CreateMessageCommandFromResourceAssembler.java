package com.example.MathPlayOpen.comunication.interfaces.rest.transform;


import com.example.MathPlayOpen.comunication.domain.models.commands.CreateMessageCommand;
import com.example.MathPlayOpen.comunication.interfaces.rest.resources.CreateMessageResource;

public class CreateMessageCommandFromResourceAssembler {
    public static CreateMessageCommand toCommandFromResource(CreateMessageResource resource)
    {
        return new CreateMessageCommand(resource.senderId(), resource.receiverId(), resource.content());
    }
}