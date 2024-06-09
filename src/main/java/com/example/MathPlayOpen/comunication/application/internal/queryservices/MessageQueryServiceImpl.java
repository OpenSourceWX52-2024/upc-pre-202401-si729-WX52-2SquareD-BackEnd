package com.example.MathPlayOpen.comunication.application.internal.queryservices;


import com.example.MathPlayOpen.comunication.domain.models.aggregates.Message;
import com.example.MathPlayOpen.comunication.domain.services.MessageQueryService;
import com.example.MathPlayOpen.comunication.infrastructure.persistence.jpa.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageQueryServiceImpl implements MessageQueryService {
    private final MessageRepository messageRepository;

    public MessageQueryServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public Optional<Message> getMessageById(Long id) {
        return messageRepository.findById(id);
    }

    @Override
    public List<Message> getMessagesBySenderId(Long senderId) {
        return messageRepository.findBySenderId(senderId);
    }

    @Override
    public List<Message> getMessagesByReceiverId(Long receiverId) {
        return messageRepository.findByReceiverId(receiverId);
    }

    @Override
    public List<Message> getMessagesBetweenUsers(Long senderId, Long receiverId) {
        return messageRepository.findBySenderIdAndReceiverId(senderId, receiverId);
    }
}