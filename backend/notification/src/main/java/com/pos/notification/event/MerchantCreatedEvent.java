package com.pos.notification.event;

public record MerchantCreatedEvent(
        Long merchantId,
        String merchantCode,
        String tradeName,
        String status
) {
}
