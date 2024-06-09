package com.example.MathPlayOpen.comunication.domain.models.aggregates;


import com.example.MathPlayOpen.comunication.domain.models.commands.CreateNotificationCommand;
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
public class Notification extends AbstractAggregateRoot<Notification> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String message;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Date createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private Date updatedAt;

    @Column(nullable = false,name = "is_read")
    private boolean read;

    protected Notification() {
    }

    public Notification(CreateNotificationCommand command, User user) {
        this.user = user;
        this.message = command.message();
        this.read = false;
    }

    public void markAsRead() {
        this.read = true;
    }
}
