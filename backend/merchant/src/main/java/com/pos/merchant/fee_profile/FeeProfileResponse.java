package com.pos.merchant.fee_profile;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class FeeProfileResponse {
    private Long id;
    private String profileCode;
    private String profileName;
    private FeeType transactionFeeType;
    private BigDecimal transactionFee;
    private BigDecimal minimumFee;
    private BigDecimal maximumFee;
    private FeeType settlementFeeType;
    private BigDecimal settlementFeeValue;
    private String currency;
    private Boolean active;
}
