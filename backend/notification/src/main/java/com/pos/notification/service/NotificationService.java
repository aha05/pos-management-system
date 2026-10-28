package com.pos.notification.service;

import com.pos.notification.entity.Notification;
import com.pos.notification.entity.NotificationStatus;
import com.pos.notification.event.MerchantCreatedEvent;
import com.pos.notification.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

import java.time.Instant;

@RequiredArgsConstructor
@Service
public class NotificationService {
    private final StreamBridge streamBridge;
    private final NotificationRepository notificationRepository;

    private static final Logger log =
            LoggerFactory.getLogger(NotificationService.class);

    public void notifyMerchantCreated(MerchantCreatedEvent event) {

        log.info(
                "Processing merchant-created notification. merchantCode={}, tradeName={}",
                event.merchantCode(),
                event.tradeName()
        );

        Notification notification = new Notification();

        notification.setRecipient(event.merchantCode());
        notification.setRecipientId(event.merchantId());
        notification.setType("IN_APP");
        notification.setSubject("Merchant Created Successfully");
        notification.setMessage(
                "Merchant " + event.tradeName()
                        + " has been created with status "
                        + event.status()
        );
        notification.setStatus(NotificationStatus.PENDING);
        notification.setCreatedAt(Instant.now());

        // Persist notification before attempting delivery
        notification = notificationRepository.save(notification);

        log.info(
                "Notification saved successfully. notificationId={}",
                notification.getId()
        );

        // TODO: Deliver notification through the selected provider.
        // Update status to SENT or FAILED after delivery.
    }

    public void sendCommunication(
            Long merchantId,
            String merchantCode,
            String tradeName,
            String status
    ) {
        MerchantCreatedEvent event = new MerchantCreatedEvent(
                merchantId,
                merchantCode,
                tradeName,
                status
        );

        boolean sent = streamBridge.send(
                "merchantCreated-out-0",
                event
        );

        if (!sent) {
            throw new IllegalStateException(
                    "Failed to publish MerchantCreatedEvent"
            );
        }
    }
}
