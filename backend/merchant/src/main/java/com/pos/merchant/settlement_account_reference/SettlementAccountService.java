package com.pos.merchant.settlement_account_reference;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SettlementAccountService {
    private final SettlementAccountRepository settlementAccountRepository;
    private final SettlementAccountMapper settlementAccountMapper;

    public List<SettlementAccountResponse> getSettlementAccounts() {
        return settlementAccountRepository.findAll()
                .stream()
                .map(settlementAccountMapper::toDto)
                .toList();
    }

    public SettlementAccountResponse addSettlementAccount(SettlementAccountRequest request) {
        var settlementAccountReference = settlementAccountMapper.toEntity(request);
        settlementAccountRepository.save(settlementAccountReference);
        return settlementAccountMapper.toDto(settlementAccountReference);
    }
}
