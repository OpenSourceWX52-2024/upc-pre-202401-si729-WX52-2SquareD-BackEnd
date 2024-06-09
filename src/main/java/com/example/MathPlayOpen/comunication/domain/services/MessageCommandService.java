package com.example.MathPlayOpen.comunication.domain.services;


import com.example.MathPlayOpen.comunication.domain.models.aggregates.Message;
import com.example.MathPlayOpen.comunication.domain.models.commands.CreateMessageCommand;

import java.util.Optional;

public interface MessageCommandService {
    Optional<Message> handle(CreateMessageCommand command);
}