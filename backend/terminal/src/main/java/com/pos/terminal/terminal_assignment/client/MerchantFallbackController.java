package com.pos.terminal.terminal_assignment.client;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class MerchantFallbackController implements MerchantFeignClient{
    @Override
    public ResponseEntity<MerchantDto> getMerchantById(Long merchantId) {
        return null;
    }

    @Override
    public ResponseEntity<BranchDto> getBranchById(Long branchId) {
        return null;
    }
}
