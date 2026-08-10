package com.pos.merchant.merchant;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class MerchantStatusConverter
        implements AttributeConverter<MerchantStatus, Integer> {

    @Override
    public Integer convertToDatabaseColumn(MerchantStatus status) {
    return status != null ? status.getValue() : null;
    }

    @Override
    public MerchantStatus convertToEntityAttribute(Integer value) {
    return value != null ? MerchantStatus.fromValue(value) : null;
    }
}
