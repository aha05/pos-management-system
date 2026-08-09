package com.pos.merchant.settlement_account_reference;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("settlement-account-reference")
@RequiredArgsConstructor
public class SettlementAccountController {
    private final SettlementAccountService settlementAccountService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<SettlementAccountResponse> getSettlementAccounts() {
        return settlementAccountService.getSettlementAccounts();
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public SettlementAccountResponse addSettlementAccount(@Valid @RequestBody SettlementAccountRequest request) {
        return settlementAccountService.addSettlementAccount(request);
    }
}
