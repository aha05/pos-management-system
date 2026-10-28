package com.pos.merchant.event;

import com.pos.merchant.merchant.MerchantStatus;

public record MerchantCreatedEvent(
        String merchantCode,
        String tradeName,
        MerchantStatus status
) {
}
