package com.pos.merchant.merchant_document;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MerchantDocumentResponse {
    private Long id;
    private Long merchantId;
    private String documentType;
    private String fileName;
    private String storagePath;
    private Boolean verified;
}
