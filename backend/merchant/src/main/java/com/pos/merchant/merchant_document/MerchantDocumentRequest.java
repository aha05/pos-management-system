package com.pos.merchant.merchant_document;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MerchantDocumentRequest {
    @NotNull(message = "Merchant Id is mandatory")
    private Long merchantId;

    @NotBlank(message = "Document Type is mandatory")
    private String documentType;

    @NotBlank(message = "File Name is mandatory")
    private String fileName;

    @NotBlank(message = "Storage Path is mandatory")
    private String storagePath;

    @NotNull(message = "Verified is mandatory")
    private Boolean verified;
}
