package com.pos.merchant.settlement_account_reference;

import com.pos.merchant.merchant.Merchant;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SettlementAccountResponse {
    private Long id;
    private Merchant merchant;
    private String accountNumber;
    private String accountHolderName;
    private String bankName;
    private String bankCode;
    private String currency;
    private Boolean isPrimary;
    private Boolean active;
    private String accountServiceReferenceId;
}
