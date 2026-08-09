package com.pos.merchant.branch;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class BranchStatusConverter
        implements AttributeConverter<BranchStatus, Integer> {

    @Override
    public Integer convertToDatabaseColumn(BranchStatus status) {
        return status != null ? status.getValue() : null;
    }

    @Override
    public BranchStatus convertToEntityAttribute(Integer value) {
        return value != null ? BranchStatus.fromValue(value) : null;
    }
}
