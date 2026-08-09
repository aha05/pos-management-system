package com.pos.merchant.merchant_document;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MerchantDocumentService {
    private final MerchantDocumentRepository merchantDocumentRepository;
    private final MerchantDocumentMapper merchantDocumentMapper;

    public List<MerchantDocumentResponse> getMerchantDocuments() {
        return merchantDocumentRepository.findAll()
                .stream()
                .map(merchantDocumentMapper::toDto)
                .toList();
    }

    public MerchantDocumentResponse addMerchantDocument(@Valid MerchantDocumentRequest request) {
        var merchantDocument = merchantDocumentMapper.toEntity(request);
        merchantDocumentRepository.save(merchantDocument);
        return merchantDocumentMapper.toDto(merchantDocument);
    }
}
