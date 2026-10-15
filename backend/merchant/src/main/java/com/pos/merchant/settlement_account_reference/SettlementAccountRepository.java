package com.pos.merchant.settlement_account_reference;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SettlementAccountRepository extends JpaRepository<SettlementAccountReference, Long> {
    Optional<SettlementAccountReference> findByMerchantId(Long id);
}
