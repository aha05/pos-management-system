package com.pos.notification.mapper;

import com.pos.notification.dto.NotificationRequest;
import com.pos.notification.entity.Notification;

public interface NotificationMapper {
    NotificationRequest toDto(Notification notification);
    Notification toEntity(NotificationRequest request);
}
