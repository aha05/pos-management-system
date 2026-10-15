package com.pos.merchant.settlement_account_reference;

import com.pos.merchant.common.ResourceNotFoundException;
import com.pos.merchant.merchant.MerchantRepository;
import com.pos.merchant.merchant.MerchantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SettlementAccountService {
    private final SettlementAccountRepository settlementAccountRepository;
    private final SettlementAccountMapper settlementAccountMapper;
    private final MerchantRepository merchantRepository;

    public SettlementAccountReference findSettlementAccountByMerchantId(Long merchantId) {
        return settlementAccountRepository.findByMerchantId(merchantId).orElse(null);
    }

    public List<SettlementAccountResponse> getSettlementAccounts() {
        return settlementAccountRepository.findAll()
                .stream()
                .map(settlementAccountMapper::toDto)
                .toList();
    }

    public SettlementAccountResponse addSettlementAccount(SettlementAccountRequest request) {
        var settlementAccountReference = settlementAccountMapper.toEntity(request);
        settlementAccountReference.setMerchant(merchantRepository.findById(request.getMerchantId()).orElseThrow(
                () -> new ResourceNotFoundException("Merchant", "merchantId", request.getMerchantId())
        ));
        settlementAccountRepository.save(settlementAccountReference);
        return settlementAccountMapper.toDto(settlementAccountReference);
    }
}
