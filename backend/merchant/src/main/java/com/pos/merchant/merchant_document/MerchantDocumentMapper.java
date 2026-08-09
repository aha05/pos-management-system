package com.pos.merchant.merchant_document;

public interface MerchantDocumentMapper {
    MerchantDocumentResponse toDto(MerchantDocument merchantDocument);
    MerchantDocument toEntity(MerchantDocumentRequest request);
}
