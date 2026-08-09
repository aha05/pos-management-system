package com.pos.merchant.settlement_account_reference;

public interface SettlementAccountMapper {
    SettlementAccountResponse toDto(SettlementAccountReference settlementAccountReference);
    SettlementAccountReference toEntity(SettlementAccountRequest request);
}
