package com.pos.notification.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "recipient_id")
    private Long recipientId;

    @Column(name = "recipient", length = 150)
    private String recipient;

    @Column(name = "type", length = 50)
    private String type;

    @Column(name = "subject", length = 150)
    private String subject;

    @Column(name = "message")
    private String message;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 20)
    private NotificationStatus status;

    @Column(name = "created_at", updatable = false)
    private Instant createdAt;

    @Column(name = "sent_at")
    private Instant sentAt;

    @Column(name = "failure_reason", length = 1000)
    private String failureReason;

    @PrePersist
    protected void onCreate() {
        createdAt = Instant.now();

        if (status == null) {
            status = NotificationStatus.PENDING;
        }
    }
}
