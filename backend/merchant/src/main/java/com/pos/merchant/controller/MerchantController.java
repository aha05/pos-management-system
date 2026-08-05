package com.pos.merchant.controller;

import com.pos.merchant.dto.MerchantRequest;
import com.pos.merchant.dto.MerchantResponse;
import com.pos.merchant.entity.Merchant;
import com.pos.merchant.service.MerchantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("merchant")
@RequiredArgsConstructor
public class MerchantController {
    private final MerchantService merchantService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<MerchantResponse> getMerchants() {
        return merchantService.getMerchants();
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public MerchantResponse getMerchants(@RequestBody MerchantRequest request) {
        return merchantService.addMerchant(request);
    }
}
