package com.pos.merchant.fee_profile;

import org.springframework.stereotype.Component;

@Component
public class FeeProfileMapperImpl implements FeeProfileMapper {
    @Override
    public FeeProfileResponse toDto(FeeProfile feeProfile) {
        return FeeProfileResponse.builder()
                .id(feeProfile.getId())
                .profileCode(feeProfile.getProfileCode())
                .profileName(feeProfile.getProfileName())
                .transactionFeeType(feeProfile.getTransactionFeeType())
                .transactionFee(feeProfile.getTransactionFee())
                .maximumFee(feeProfile.getMaximumFee())
                .minimumFee(feeProfile.getMinimumFee())
                .settlementFeeType(feeProfile.getSettlementFeeType())
                .settlementFeeValue(feeProfile.getSettlementFeeValue())
                .currency(feeProfile.getCurrency())
                .active(feeProfile.getActive())
                .build();
    }

    @Override
    public FeeProfile toEntity(FeeProfileRequest request) {
        FeeProfile feeProfile = new FeeProfile();
        feeProfile.setProfileCode(request.getProfileCode());
        feeProfile.setProfileName(request.getProfileName());
        feeProfile.setTransactionFeeType(request.getTransactionFeeType());
        feeProfile.setTransactionFee(request.getTransactionFee());
        feeProfile.setMinimumFee(request.getMinimumFee());
        feeProfile.setMaximumFee(request.getMaximumFee());
        feeProfile.setSettlementFeeType(request.getSettlementFeeType());
        feeProfile.setSettlementFeeValue(request.getSettlementFeeValue());
        feeProfile.setCurrency(request.getCurrency());
        feeProfile.setActive(request.getActive());
        return feeProfile;
    }
}
