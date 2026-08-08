package com.pos.merchant.fee_profile;

public interface FeeProfileMapper {
    FeeProfileResponse toDto(FeeProfile feeProfile);
    FeeProfile toEntity(FeeProfileRequest feeProfileRequest);
}
