package com.pos.merchant.merchant;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MerchantResponse getMerchantById(@PathVariable(name = "id") Long merchantId) {
        return merchantService.getMerchantById(merchantId);
    }

    @GetMapping("/info")
    @ResponseStatus(HttpStatus.OK)
    public List<MerchantInformation> getMerchantInfo() {
        return merchantService.getMerchantInfo();
    }

    @GetMapping("/info/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MerchantInformation getMerchantInfoById(@PathVariable(name = "id") Long merchantId) {
        return merchantService.getMerchantInfoById(merchantId);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public MerchantResponse addMerchant(@Valid @RequestBody MerchantRequest request) {
        return merchantService.addMerchant(request);
    }

}
