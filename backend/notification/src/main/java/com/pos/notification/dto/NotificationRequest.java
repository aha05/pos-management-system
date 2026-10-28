package com.pos.notification.dto;

import com.pos.notification.entity.NotificationStatus;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class NotificationRequest {
    private Long id;
    private Long recipientId;
    private String recipient;
    private String type;
    private String subject;
    private String message;
    private NotificationStatus status;
    private String failureReason;
    private Instant createdAt;
    private Instant sentAt;
}
