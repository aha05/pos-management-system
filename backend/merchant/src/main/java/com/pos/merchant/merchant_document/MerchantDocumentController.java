package com.pos.merchant.merchant_document;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("merchant-document")
@RequiredArgsConstructor
public class MerchantDocumentController {
    private final MerchantDocumentService merchantDocumentService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<MerchantDocumentResponse> getMerchantDocuments() {
        return merchantDocumentService.getMerchantDocuments();
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public MerchantDocumentResponse addMerchantDocument(@Valid @RequestBody MerchantDocumentRequest request) {
        return merchantDocumentService.addMerchantDocument(request);
    }
}
