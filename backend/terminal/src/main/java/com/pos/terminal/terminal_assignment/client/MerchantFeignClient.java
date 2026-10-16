package com.pos.terminal.terminal_assignment.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("merchant")
public interface MerchantFeignClient {
    @GetMapping(value = "/merchant/{id}",consumes = "application/json")
    public ResponseEntity<MerchantDto> getMerchantById(@PathVariable(name = "id") Long merchantId);

    @GetMapping(value = "/merchant/branch/{id}",consumes = "application/json")
    public ResponseEntity<BranchDto> getBranchById(@PathVariable(name = "id") Long branchId);
}
