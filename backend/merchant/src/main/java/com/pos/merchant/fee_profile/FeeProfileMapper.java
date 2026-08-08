package com.pos.merchant.fee_profile;

public interface FeeProfileMapper {
    public FeeProfileResponse toDto(FeeProfile feeProfile);
    public FeeProfile toEntity(FeeProfileRequest feeProfileRequest);
}
