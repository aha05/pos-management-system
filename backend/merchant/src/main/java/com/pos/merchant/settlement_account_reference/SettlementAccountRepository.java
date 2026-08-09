package com.pos.merchant.settlement_account_reference;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SettlementAccountRepository extends JpaRepository<SettlementAccountReference, Long> {
}
