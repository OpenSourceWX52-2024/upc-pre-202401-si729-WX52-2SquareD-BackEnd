package com.example.MathPlayOpen.comunication.domain.models.aggregates;


import com.example.MathPlayOpen.comunication.domain.models.commands.CreateMessageCommand;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)

public class Message extends AbstractAggregateRoot<Message> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sender_id", nullable = false)
    private User sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id", nullable = false)
    private User receiver;


    @Column( nullable = false)
    private String content;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Date createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private Date updatedAt;

    protected Message() {
    }

    public Message(CreateMessageCommand command, User sender, User receiver) {
        this.sender = sender;
        this.receiver = receiver;
        this.content = command.content();
    }
}
