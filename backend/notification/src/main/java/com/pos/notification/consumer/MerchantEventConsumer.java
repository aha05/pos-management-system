package com.pos.notification.consumer;

import com.pos.notification.event.MerchantCreatedEvent;
import com.pos.notification.service.NotificationService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@AllArgsConstructor
@Configuration
public class MerchantEventConsumer {
    private final NotificationService notificationService;

    @Bean
    public Consumer<MerchantCreatedEvent> merchantCreatedConsumer() {
        return notificationService::notifyMerchantCreated;
    }
}
