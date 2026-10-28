package com.pos.merchant.event;

public record MerchantCreatedEvent(
        Long merchantId,
        String merchantCode,
        String tradeName,
        String status
) {
}
