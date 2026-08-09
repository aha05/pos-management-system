package com.pos.merchant.settlement_account_reference;

import com.pos.merchant.merchant.Merchant;
import com.pos.merchant.merchant.MerchantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SettlementAccountMapperImpl implements SettlementAccountMapper {
    private final MerchantRepository merchantRepository;

    @Override
    public SettlementAccountResponse toDto(SettlementAccountReference settlementAccountReference) {
        return SettlementAccountResponse.builder()
                .id(settlementAccountReference.getId())
                .merchant(settlementAccountReference.getMerchant())
                .accountNumber(settlementAccountReference.getAccountNumber())
                .accountHolderName(settlementAccountReference.getAccountHolderName())
                .bankName(settlementAccountReference.getBankName())
                .bankCode(settlementAccountReference.getBankCode())
                .currency(settlementAccountReference.getCurrency())
                .isPrimary(settlementAccountReference.getIsPrimary())
                .active(settlementAccountReference.getActive())
                .accountServiceReferenceId(settlementAccountReference.getAccountServiceReferenceId())
                .build();
    }

    @Override
    public SettlementAccountReference toEntity(SettlementAccountRequest request) {
        var settlementAccountReference = new SettlementAccountReference();
        settlementAccountReference.setMerchant(getMerchantById(request.getMerchantId()));
        settlementAccountReference.setAccountNumber(request.getAccountNumber());
        settlementAccountReference.setAccountHolderName(request.getAccountHolderName());
        settlementAccountReference.setBankName(request.getBankName());
        settlementAccountReference.setBankCode(request.getBankCode());
        settlementAccountReference.setCurrency(request.getCurrency());
        settlementAccountReference.setIsPrimary(request.getIsPrimary());
        settlementAccountReference.setActive(request.getActive());
        settlementAccountReference.setAccountServiceReferenceId(request.getAccountServiceReferenceId());
        return settlementAccountReference;
    }

    public Merchant getMerchantById(Long merchantId){
        return merchantRepository.findById(merchantId).orElse(null);
    }
}
