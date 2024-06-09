package com.example.MathPlayOpen.comunication.application.internal.commandservices;

import com.example.MathPlayOpen.comunication.domain.models.aggregates.Message;
import com.example.MathPlayOpen.comunication.domain.models.aggregates.User;
import com.example.MathPlayOpen.comunication.domain.models.commands.CreateMessageCommand;
import com.example.MathPlayOpen.comunication.domain.services.MessageCommandService;
import com.example.MathPlayOpen.comunication.infrastructure.persistence.jpa.MessageRepository;
import com.example.MathPlayOpen.comunication.infrastructure.persistence.jpa.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MessageCommandServiceImpl implements MessageCommandService {
    private final UserRepository userRepository;
    private final MessageRepository messageRepository;

    public MessageCommandServiceImpl(UserRepository userRepository, MessageRepository messageRepository) {
        this.userRepository = userRepository;
        this.messageRepository = messageRepository;
    }

    @Override
    public Optional<Message> handle(CreateMessageCommand command) {
        User sender = userRepository.findById(command.senderId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid senderId"));
        User receiver = userRepository.findById(command.receiverId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid receiverId"));
        Message message = new Message(command, sender, receiver);
        Message createdMessage = messageRepository.save(message);
        return Optional.of(createdMessage);
    }
}