package com.pos.merchant.fee_profile;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class FeeProfileRequest {
    @NotBlank(message = "Profile Code is mandatory")
    private String profileCode;

    @NotBlank(message = "Profile Name is mandatory")
    private String profileName;

    @NotNull(message = "Transaction FeeType is mandatory")
    private FeeType transactionFeeType;

    @PositiveOrZero(message = "Transaction Fee can't be negative")
    @NotNull(message = "Transaction Fee is mandatory")
    private BigDecimal transactionFee;

    @PositiveOrZero(message = "Minimum Fee can't be negative")
    @NotNull(message = "Minimum Fee is mandatory")
    private BigDecimal minimumFee;

    @PositiveOrZero(message = "Maximum Fee can't be negative")
    @NotNull(message = "Maximum Fee is mandatory")
    private BigDecimal maximumFee;

    @NotNull(message = "Settlement FeeType is mandatory")
    private FeeType settlementFeeType;

    @PositiveOrZero(message = "Settlement FeeValue can't be negative")
    @NotNull(message = "Settlement FeeValue is mandatory")
    private BigDecimal settlementFeeValue;

    @NotBlank(message = "Currency is mandatory")
    private String currency;

    @NotNull(message = "Active Code is mandatory")
    private Boolean active;

}
