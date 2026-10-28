package com.pos.notification.repository;

import com.pos.notification.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
