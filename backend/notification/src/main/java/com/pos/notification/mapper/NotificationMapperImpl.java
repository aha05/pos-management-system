package com.pos.notification.mapper;

import com.pos.notification.dto.NotificationRequest;
import com.pos.notification.entity.Notification;

public class NotificationMapperImpl implements NotificationMapper{
    @Override
    public NotificationRequest toDto(Notification notification) {
        return NotificationRequest.builder()
                .id(notification.getId())
                .recipientId(notification.getRecipientId())
                .recipient(notification.getRecipient())
                .type(notification.getType())
                .subject(notification.getSubject())
                .message(notification.getMessage())
                .status(notification.getStatus())
                .failureReason(notification.getFailureReason())
                .build();
    }

    @Override
    public Notification toEntity(NotificationRequest request) {
        Notification notification = new Notification();
        notification.setRecipient(request.getRecipient());
        notification.setRecipient(request.getRecipient());
        notification.setType(request.getType());
        notification.setSubject(request.getSubject());
        notification.setMessage(request.getMessage());
        return notification;
    }
}
