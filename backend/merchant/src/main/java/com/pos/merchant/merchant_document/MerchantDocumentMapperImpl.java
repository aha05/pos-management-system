package com.pos.merchant.merchant_document;

import com.pos.merchant.merchant.MerchantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MerchantDocumentMapperImpl implements MerchantDocumentMapper {
    private final MerchantService merchantService;

    @Override
    public MerchantDocumentResponse toDto(MerchantDocument merchantDocument) {

        return MerchantDocumentResponse.builder()
                .id(merchantDocument.getId())
                .merchantId(merchantDocument.getMerchant().getId())
                .documentType(merchantDocument.getDocumentType())
                .fileName(merchantDocument.getFileName())
                .storagePath(merchantDocument.getStoragePath())
                .verified(merchantDocument.getVerified())
                .build();
    }

    @Override
    public MerchantDocument toEntity(MerchantDocumentRequest request) {
        MerchantDocument merchantDocument = new MerchantDocument();
        merchantDocument.setMerchant(merchantService
                .findMerchantById(request.getMerchantId()));
        merchantDocument.setDocumentType(request.getDocumentType());
        merchantDocument.setFileName(request.getFileName());
        merchantDocument.setStoragePath(request.getStoragePath());
        merchantDocument.setVerified(request.getVerified());
        return merchantDocument;
    }
}
