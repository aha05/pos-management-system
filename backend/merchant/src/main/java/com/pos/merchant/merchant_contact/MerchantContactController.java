package com.pos.merchant.merchant_contact;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("merchant-contact")
@RequiredArgsConstructor
public class MerchantContactController {
    private final MerchantContactService merchantContactService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<MerchantContactResponse> getMerchantContacts() {
        return merchantContactService.getMerchantContacts();
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public MerchantContactResponse addMerchantContact(@Valid @RequestBody MerchantContactRequest request) {
        return merchantContactService.addMerchantContact(request);
    }
}
