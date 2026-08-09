package com.pos.merchant.settlement_account_reference;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SettlementAccountRequest {
    @NotNull(message = "merchantId is mandatory")
    private Long merchantId;

    @NotBlank(message = "Account Number is mandatory")
    private String accountNumber;

    @NotBlank(message = "Account Holder Name is mandatory ")
    private String accountHolderName;

    @NotBlank(message = "Bank Name is mandatory")
    private String bankName;

    @NotBlank(message = "Bank Code is mandatory")
    private String bankCode;

    @NotBlank(message = "Currency is mandatory")
    private String currency;

    @NotNull(message = "Is Primary is mandatory")
    private Boolean isPrimary;

    @NotNull(message = "Active is mandatory")
    private Boolean active;

    @NotBlank(message = "AccountServiceReferenceId is mandatory")
    private String accountServiceReferenceId;
}
